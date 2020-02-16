package com.py.examples.juc.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 享学课堂[Roy老师]
 */
public class UseCyclicBarrier {
    static CyclicBarrier barrier = new CyclicBarrier(2);
    public static void main(String[] args) {
        MyTask a = new MyTask();
        MyTaskB b = new MyTaskB();
        a.start();
        b.start();
    }

    static class MyTask extends Thread{
        @Override
        public void run() {
            try {
                System.out.println("AAA1");
                Thread.sleep(3000);
                barrier.await();
                System.out.println("AAA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    static class MyTaskB extends Thread{
        @Override
        public void run() {
            try {
                System.out.println("BBB1");
                Thread.sleep(300);
                barrier.await();
                System.out.println("BBB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
