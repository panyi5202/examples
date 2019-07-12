package com.py.examples.netty.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panyi on 18-7-31.
 */
public class Chapter1App {
    public static void main(String[] args) {
        try {
            new EchoServer(8888).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
