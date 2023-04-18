package com.clay.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] number = new int[8];
        for (int i = 0; i < 8; i++) {
            number[i] = (int)(Math.random()*8);
        }
        Arrays.stream(insertSort(number)).forEach(System.out::println);
    }

    private static int[] insertSort(int[] number) {
        int temp;
        int target;
        for (int i = 0; i < number.length - 1; i++) {
            target = number[i + 1];
            for (int j = i ; j >= 0; j--) {
                if (target < number[j]){
                    temp = number[j];
                    number[j] = target;
                    number[j + 1] = temp;
                }
            }

        }
        return number;
    }
}
