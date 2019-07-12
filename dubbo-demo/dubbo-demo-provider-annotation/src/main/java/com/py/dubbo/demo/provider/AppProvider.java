package com.py.dubbo.demo.provider;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author panyi on 18-8-17.
 */
public class AppProvider {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext acc=new AnnotationConfigApplicationContext(DubboConfig.class);
        acc.start();
        System.in.read();
    }
}
