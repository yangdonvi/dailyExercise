package com.donvi.thread.safe;

public class DeadLock implements Runnable{
    public static Object o1= new Object();
    public static Object o2= new Object();

    public int flag;

    public DeadLock(int flag) {
        super();
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag==1) {
            synchronized (o1) {
                System.out.println("o1获得o1锁");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("o1获得o2锁");
                }
            }
        }else {
            synchronized (o2) {
                System.out.println("o2获得o2锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("o2获得o1锁");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock(1);
        DeadLock deadLock2 = new DeadLock(2);
        new Thread(deadLock1).start();
        new Thread(deadLock2).start();
    }

}