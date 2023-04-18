package com.clay;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class ADigitInASequenceOfDigits {
    public static void main(String[] args) {
        System.out.println(new ADigitInASequenceOfDigits().findNthDigit(100));
    }

    public int findNthDigit(int n) {
        if (0 <= n && n <= 9){
            return n;
        }

        int singleDigit = n % 10;
        int otherDigit = (n - singleDigit) /10;
        if (otherDigit % 2 == 0){
            if (singleDigit % 2 == 0){
                return otherDigit / 2;
            }else {
                if (singleDigit == 1){
                    return 5;
                }
                if (singleDigit == 3){
                    return 6;
                }
                if (singleDigit == 5){
                    return 7;
                }
                if (singleDigit == 7){
                    return 8;
                }
                if (singleDigit == 9){
                    return 9;
                }

            }
        }else {
            if (singleDigit % 2 == 0){
                return otherDigit / 2 + 1;
            }else {
                return singleDigit / 2;
            }
        }
        return 0;
    }
}
