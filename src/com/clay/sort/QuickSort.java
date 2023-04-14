package com.clay.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] number = new int[8];
        for (int i = 0; i < 8; i++) {
            number[i] = (int)(Math.random()*8);
        }
        quickSort(number,0,number.length-1);
        Arrays.stream(number).forEach(System.out::println);
        System.out.println("==============================");
        Arrays.stream(number).forEach(System.out::println);
    }

    private static void quickSort(int[] number,int left, int right) {
        int l = left;
        int r = right;
        int mid = (left + right) / 2;
        int base = number[mid];
        while (l < r){
            while (number[l] < base){
                l++;
            }
            while (number[r] > base){
                r--;
            }
            if (l >= r){
                break;
            }
            int temp = number[l];
            number[l] = number[r];
            number[r] = temp;
            if (number[l] == base ){
                 r--;
            }
            if (number[r] ==  base){
                l++;
            }
        }
        if (l == r){
            l++;
            r--;
        }
        if (l < right){
            quickSort(number,l,right);
        }
        if (r > left){
            quickSort(number,left,r);
        }
    }
}
