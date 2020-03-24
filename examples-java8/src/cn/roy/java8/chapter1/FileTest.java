package cn.roy.java8.chapter1;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Roy
 */
public class FileTest {
    public static void main(String[] args) {
        String path = "D:\\link";
        // before Java8
        // ListFilesBeforeJava8(path);
        // in Java8
        File[] files = new File(path).listFiles(File::isHidden);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    private static void ListFilesBeforeJava8(String path) {
        File[] files = new File(path).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
