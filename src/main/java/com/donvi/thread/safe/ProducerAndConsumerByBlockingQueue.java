package com.donvi.thread.safe;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Donvi Yang on 2020/4/2.
 */
public class ProducerAndConsumerByBlockingQueue {
    /**
     * productPool, maxSize = 10
     */
    private BlockingDeque<Integer> productPool = new LinkedBlockingDeque<>(10);

    class Producer extends Thread {
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                try {
                    productPool.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Produce a product, current products num: " + productPool.size());
                try {
                    Thread.sleep(new Random().nextInt(100) + 200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                try {
                    productPool.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Consume a product, current products num: " + productPool.size());
                try {
                    Thread.sleep(new Random().nextInt(100) + 300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerByBlockingQueue testQueue = new ProducerAndConsumerByBlockingQueue();
        Producer producer = testQueue.new Producer();
        Consumer consumer = testQueue.new Consumer();
        producer.start();
        consumer.start();
    }


}
