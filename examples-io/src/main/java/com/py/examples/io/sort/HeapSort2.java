package com.py.examples.io.sort;

import java.util.*;

/**
 * @author panyi on 2019/9/10.
 */
public class HeapSort2 {
    static int len;    // 因为声明的多个函数都需要数据长度，所以把len设置成为全局变量

    static void buildMaxHeap(int[] arr) {   // 建立大顶堆
        len = arr.length;
        for (int i = Math.floorDiv(len,2) -1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    static void  heapify(int[] arr, int i) {     // 堆调整
        int left = 2 * i + 1,
                right = 2 * i + 2,
                largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    static void  swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] heapSort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0);
        }
        return arr;
    }

    public static void main(String[] args) {
        // 1 准备一个数组
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        // 2 对数组排序
        heapSort(a);
        // 3 打印排序后的结果
        System.out.println(Arrays.toString(a));

    }
}
