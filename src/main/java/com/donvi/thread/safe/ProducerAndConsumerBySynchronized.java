package com.donvi.thread.safe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Donvi Yang on 2020/4/2.
 */
public class ProducerAndConsumerBySynchronized {
    /**
     * productPool, maxSize = 10
     */
    private final int maxProductPool = 10;

    /**
     * productPool, minSize = 0
     */
    private final int minProductPool = 0;

    private Queue<Integer> productPool = new LinkedList<>();

    class Producer extends Thread {
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                synchronized (productPool) {
                    while (maxProductPool == productPool.size()) {
                        System.out.println("Pool is full.");
                        productPool.notify();
                        try {
                            productPool.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    productPool.add(1);
                    productPool.notify();
                    System.out.println("Produce a product, current products num: " + productPool.size());
                    try {
                        Thread.sleep(new Random().nextInt(100) + 200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                synchronized (productPool) {
                    while (minProductPool == productPool.size()) {
                        System.out.println("Pool is empty.");
                        productPool.notify();
                        try {
                            productPool.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    productPool.poll();
                    productPool.notify();
                    System.out.println("Consume a product, current products num: " + productPool.size());
                    try {
                        Thread.sleep(new Random().nextInt(100) + 300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerBySynchronized testSync = new ProducerAndConsumerBySynchronized();
        Producer producer = testSync.new Producer();
        Consumer consumer = testSync.new Consumer();
        producer.start();
        consumer.start();
    }

}
