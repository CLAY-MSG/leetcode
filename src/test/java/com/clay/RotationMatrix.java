package com.clay;

import java.util.Arrays;

/**
 * 48. 旋转图像
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class RotationMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            temp[i] = matrix[i].clone();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, y = matrix[0].length - 1; j < matrix[i].length && y >= 0; j++, y--) {
                matrix[i][j] = temp[y][i];
            }
        }
    }



}
