package com.clay;

/**
 * 1812.判断国际象棋棋盘中一个格子的颜色
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class DetermineTheColorOfAGridOnAChessBoard {
    public static void main(String[] args) {
        String coordinates = "a5";
        System.out.println(new DetermineTheColorOfAGridOnAChessBoard().squareIsWhite(coordinates));
    }
    public boolean squareIsWhite(String coordinates) {
        char a=coordinates.charAt(0);
        char b=coordinates.charAt(1);
        boolean flag1 = a == 'a' || a == 'c' || a == 'e' || a == 'g';
        boolean flag2 = b == '1' || b == '3' || b == '5' || b == '7';
        return (!flag1 || !flag2) && (flag1 || flag2);
    }

}
