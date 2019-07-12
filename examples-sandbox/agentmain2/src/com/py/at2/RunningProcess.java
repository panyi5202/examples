package com.py.at2;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author panyi on 18-5-17.
 */
public class RunningProcess {
    public static void main(String[] args) {
        System.out.println("Current processid = " + getCurrentThreadID());
        while (true) {
            try {
                new DemoPrint().print();

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取当前进程ID
     */
    private static Integer getCurrentThreadID() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        return Integer.parseInt(name.substring(0, name.indexOf("@")));
    }
}
