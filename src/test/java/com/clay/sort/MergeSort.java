package com.clay.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] number = new int[8];
        for (int i = 0; i < 8; i++) {
            number[i] = (int)(Math.random()*8);
        }
        Arrays.stream(mergeSort(number)).forEach(System.out::println);
    }

    private static int[] mergeSort(int[] number) {
        return number;
    }
}
