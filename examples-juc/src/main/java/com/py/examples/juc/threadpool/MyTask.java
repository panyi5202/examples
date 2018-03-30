package com.py.examples.juc.threadpool;

/**
 * @author panyi on 18-3-30.
 * @since V3.0.1
 */
public class MyTask implements Runnable {
    public int num;

    public MyTask(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("执行任务:" + num);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
