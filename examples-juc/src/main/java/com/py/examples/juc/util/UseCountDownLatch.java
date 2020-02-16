package com.py.examples.juc.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;

/**
 * @author 享学课堂[Roy老师]
 */
public class UseCountDownLatch {
    static CountDownLatch cdl = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        MyTaskA a = new MyTaskA();
        a.start();
        Thread.sleep(1000);
        cdl.countDown();
        System.out.println("A is created");

        MyTaskB b = new MyTaskB();
        b.start();
        Thread.sleep(1000);
        cdl.countDown();
        System.out.println("B is created");


    }

    static class MyTaskA extends Thread {
        @Override
        public void run() {
            try {
                cdl.await();
                System.out.println("AAA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyTaskB extends Thread {
        @Override
        public void run() {
            try {
                cdl.await();
                System.out.println("BBB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
