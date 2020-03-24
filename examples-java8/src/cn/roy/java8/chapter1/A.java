package cn.roy.java8.chapter1;

import java.io.File;

/**
 * @author Roy
 */
public class A {
    public static void main(String[] args) {
        String path = "D:\\link";
        new File(path).listFiles(file -> file.isHidden());
    }
}
