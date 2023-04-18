package com.clay.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] number = new int[8];
        for (int i = 0; i < 8; i++) {
            number[i] = (int)(Math.random()*8);
        }
        Arrays.stream(selectSort(number)).forEach(System.out::println);
    }

    private static int[] selectSort(int[] number) {
        int temp;
        int index = 0;
        for (int i = 0; i < number.length; i++) {
            temp = number[i];
            for (int j = i + 1; j < number.length; j++) {
                if (temp > number[j]){
                    temp = number[j];
                    index = j;
                }
            }
            if (i != index) {
                number[index] = number[i];
                number[i] = temp;
            }
        }
        return number;
    }
}
