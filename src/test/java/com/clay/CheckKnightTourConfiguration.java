package com.clay;

/**
 * 2596.检查骑士巡视方案
 * 骑士在一张nxn的棋盘上巡视。在有效的巡视方案中，骑士会从棋盘的左上角出发，并且访问棋盘上的每个格子恰好一次。
 * 给你一个nxn的整数矩阵grid，由范围[0,n*n-1]内的不同整数组成，其中grid[row][col]表示单元格(row,col)是骑士访问的第grid[row][col]个
 * 单元格。骑士的行动是从下标0开始的。如果grid表示了骑士的有效巡视方案，返回true；否则返回false。
 * @author CLAY
 */
public class CheckKnightTourConfiguration {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{8, 3, 6}, {5, 0, 1},{2, 7, 4}};
//        int[][] grid = new int[][]{{0,11,16,5,20}, {17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};

        //
        /*grid[0] = new int[]{0, 11, 16, 5, 20};
        grid[1] = new int[]{17,4,19,10,15};*/

        System.out.println(checkValidGrid(grid));
    }

    public static boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0){
            return false;
        }
        return checkValid(grid, 0, 0, 0);
    }

    public static boolean checkValid(int[][] grid, int row, int col, int n) {
        if  (row + 2 <= grid.length - 1)
        {
            if (col + 1 <= grid[row].length - 1){
                if (grid[row +2 ][col + 1] == n + 1){
                    return checkValid(grid,row + 2, col + 1, n + 1);
                }
            }
            if (col - 1 >= 0){
                if (grid[row + 2 ][col - 1] == n + 1){
                    return checkValid(grid,row + 2, col - 1, n + 1);
                }
            }
        }
        if (row - 2 >= 0 )  {
            if (col + 1 <= grid[row].length - 1){
                if (grid[row - 2][col + 1] == n + 1){
                    return checkValid(grid,row - 2, col + 1, n + 1);
                }
            }
            if (col - 1 >= 0){
                if (grid[row - 2][col - 1] == n + 1){
                    return checkValid(grid,row - 2, col - 1, n + 1);
                }
            }

        }
        if (col + 2 <= grid[row].length - 1) {
            if (row + 1 <= grid.length - 1){
                if (grid[row + 1 ][col + 2] == n + 1){
                    return checkValid(grid,row + 1, col + 2, n + 1);
                }
            }
            if (row - 1 >= 0){
               if (grid[row - 1 ][col + 2] == n + 1){
                   return checkValid(grid,row - 1, col + 2, n + 1);
               }
            }
        }
        if (col - 2 >= 0 ) {
            if (row + 1 <= grid.length - 1){
                if (grid[row + 1 ][col - 2] == n + 1){
                    return checkValid(grid,row + 1, col - 2, n + 1);
                }
            }
            if (row - 1 >= 0){
                if (grid[row - 1 ][col - 2] == n + 1){
                    return checkValid(grid,row - 1, col - 2, n + 1);
                }
            }
        }
        return n == grid.length * grid.length - 1;
    }
}
