package com.clay.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] number = new int[8];
        for (int i = 0; i < 8; i++) {
            number[i] = (int)(Math.random()*80);
        }
        Arrays.stream(bubbleSort(number)).forEach(System.out::println);
    }

    private static int[] bubbleSort(int[] number) {
        boolean flag = false;
        int temp;
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                if (number[i] > number[j]){
                    flag = true;
                    temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
        return number;
    }


}
