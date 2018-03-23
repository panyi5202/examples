package com.py.examples.test;

import java.util.Arrays;

/**
 * @author panyi on 18-3-23.
 * @since V3.0.1
 */
public class Test {
    public static void main(String[] args) {
        String a = "adcdfdf";
        byte[] bytes = a.getBytes();
        System.out.println(Arrays.toString(bytes));
        String s = new String(bytes);
        System.out.println("aa");
    }
}
