package com.py.examples.juc.threadpool;

import java.util.HashSet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池小例子：初始化时不新建线程；执行任务时，如果线程池没有满，则创建线程；
 * 如果线程池已满，则把任务加到待执行队列中；线程执行完任务后，从队列中拉取任务去执行；
 *
 * @author panyi on 18-3-30.
 * @since V3.0.1
 */
public class MyThreadPool {
    public volatile int count = 0; // 正在执行的work个数
    private int poolSize;
    private LinkedBlockingDeque<MyTask> workQueue;
    private HashSet<MyWorker> workers = new HashSet<>();
    private ReentrantLock lock = new ReentrantLock();

    public MyThreadPool(int poolSize) {
        this.poolSize = poolSize;
        workQueue = new LinkedBlockingDeque<MyTask>(5);
    }

    public static void main(String[] args) {
        MyThreadPool tp = new MyThreadPool(2);
        for (int i = 0; i < 5; i++) {
            tp.execute(new MyTask(i));
            System.out.println("正在执行的任务个数：" + tp.count);
            System.out.println("等待执行的任务个数：" + tp.workQueue.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void execute(MyTask myTask) {
        System.out.println("又来一个新任务："+myTask.num);
        if (count >= poolSize) {
            workQueue.offer(myTask);
        } else {
            MyWorker worker = new MyWorker(myTask, this);
            Thread thread = new Thread(worker);
            workers.add(worker);
            count++;
            thread.start();
        }
    }

    public MyTask getTask() {
        try {
            MyTask take = workQueue.take();
            System.out.println("从任务池取走一个任务:"+take.num);
            System.out.println("任务池还剩下："+workQueue.size());
            return take;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
