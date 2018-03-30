package com.py.examples.juc.threadpool;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panyi on 18-3-30.
 * @since V3.0.1
 */
public class MyWorker implements Runnable {
    private MyTask firstTask;
    private MyThreadPool tp;
    private final ReentrantLock lock = new ReentrantLock();

    public MyWorker(MyTask firstTask, MyThreadPool tp) {
        this.firstTask = firstTask;
        this.tp = tp;
        System.out.println("创建了一个work：" + tp.count);
    }

    @Override
    public void run() {
        Runnable task = firstTask;
        task.run();
        while ((task = tp.getTask()) != null) {
            task.run();
            System.out.println("执行任务完成:");
        }
    }
}
