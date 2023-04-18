package com.clay;

import java.util.Arrays;

/**
 * 867.转置矩阵
 * @author MSG
 */
public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6}};
        System.out.println(matrix[0].length);
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }

    public static int[][] transpose(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = matrix[j][i];
            }
        }
        return matrix;
    }
}
