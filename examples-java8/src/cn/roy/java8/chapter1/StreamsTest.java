package cn.roy.java8.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Roy
 */
public class StreamsTest {
    public static void main(String[] args) {
        // 并行处理
        List<Integer> ints = Arrays.asList(34, 34, 45, 74, 78, 98);
        List<Integer> collect = ints.stream().filter(item -> item > 50).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
