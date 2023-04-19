package com.clay;

/**
 * 1886. 判断矩阵经轮转后是否一致
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，
 * 如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 */
public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {

    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        int len = mat.length;
        int[][] newMat = new int[len][len];

        boolean flag = true;
        int count = 0;
        int x = 0;
        int m = 0;
        int n = 0;
        int y = mat.length - 1;
        while (count < 4){
            flag = true;
            while (y >= 0 && m < len) {
                while (x < len && n < len){
                    newMat[x][y] = mat[m][n];
                    x++;
                    n++;
                }
                y--;
                m++;
                x = 0;
                n = 0;
            }
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (newMat[i][j] != target[i][j]){
                        flag = false;
                        break;
                    }
                }
                if (!flag){
                    break;
                }
            }
            if (flag){
                break;
            }else{
                count++;
                for (int i = 0; i < len; i++) {
                    System.arraycopy(newMat[i], 0, mat[i], 0, len);
                }
                x = 0;
                m = 0;
                n = 0;
                y = mat.length - 1;
            }
        }
        return flag;
    }
}
