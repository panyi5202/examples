package com.py.at;

import java.lang.management.ManagementFactory;

/**
 * @author panyi on 18-5-17.
 */
public class TargetVM {
    public static void main(String[] args) throws InterruptedException{
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        while(true){
            Thread.sleep(1000);
        }
    }
}
