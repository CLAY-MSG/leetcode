package com.clay;

/**
 * 400. 第 N 位数字
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 * @author CLAY
 */
public class NthDigit {
    public static void main(String[] args) {
        System.out.println(new NthDigit().findNthDigit2(999999999));
        System.out.println(findNthDigit(999999999));
    }

    public static  int findNthDigit(int n) {
        if ( n <= 9){
            return n;
        }

        long sum = 0;
        long m = 0;
        int i = 0;
        do {
            i++;
            sum = m;
            m += 9 * i * Math.pow(10, i - 1);
        } while (m <= n );
        int a = (int) (n - sum) ;
        int q = a % i;
        int target = a / i;
        if (i  == 2){
            target = target + 9;
        }else if (i > 2 ){
            target = target + (int)Math.pow(10, i - 1) - 1;
        }

        if (q != 0){
            target += 1;
        }

        int weishu = (int)Math.log10(target) + 1;

        int result = 0;
        if (q == 0){
            result = target % 10;
        }else if (q == 1){
            result = target / (int) (Math.pow(10, weishu - 1));
        }else{
            result = target % (int) (Math.pow(10, weishu - (q - 1))) / (int) (Math.pow(10, weishu - q));
        }
        return result;
    }
    public int findNthDigit2(int n) {
        int low = 1, high = 9;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (totalDigits(mid) < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int d = low;
        int prevDigits = totalDigits(d - 1);
        int index = n - prevDigits - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    public int totalDigits(int length) {
        int digits = 0;
        int curLength = 1, curCount = 9;
        while (curLength <= length) {
            digits += curLength * curCount;
            curLength++;
            curCount *= 10;
        }
        return digits;
    }

}
