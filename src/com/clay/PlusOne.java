package com.clay;

import java.util.Arrays;

/**
 * 66.加一
 *
 * @author MSG
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i] += 1;
        while (digits[i] < 0 || digits[i] > 9) {
            digits[i] = 0;
            i = i - 1;
            if (i == -1){
                digits = new int[digits.length + 1];
                digits[0] = 1;
                return digits;
            }
            digits[i] += 1;
        }
        return digits;
    }
}
