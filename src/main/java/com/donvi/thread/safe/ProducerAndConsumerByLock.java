package com.donvi.thread.safe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Donvi Yang on 2020/4/2.
 */
public class ProducerAndConsumerByLock {
    /**
     * productPool, maxSize = 10
     */
    private final int maxProductPool = 10;

    /**
     * productPool, minSize = 0
     */
    private final int minProductPool = 0;

    private final Lock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    private Queue<Integer> productPool = new LinkedList<>();

    class Producer extends Thread {
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                lock.lock();
                try {
                    while (productPool.size() == maxProductPool) {
                        System.out.println("Pool is full.");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    productPool.add(1);
                    condition.signal();
                    System.out.println("Produce a product, current products num: " + productPool.size());
                    try {
                        Thread.sleep(new Random().nextInt(100) + 200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                lock.lock();
                try {
                    while (productPool.size() == minProductPool) {
                        System.out.println("Pool is empty.");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    productPool.poll();
                    condition.signal();
                    System.out.println("Consume a product, current products num: " + productPool.size());
                    try {
                        Thread.sleep(new Random().nextInt(100) + 300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerByLock testLock = new ProducerAndConsumerByLock();
        Producer producer = testLock.new Producer();
        Consumer consumer = testLock.new Consumer();
        producer.start();
        consumer.start();
    }

}
