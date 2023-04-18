package com.clay;

/**
 * 2396.严格回文的数字
 * 如果一个整数n在b进制下（b为2到n-2之间的所有整数）对应的字符串全部都是回文的，那么我们称这个数n是严格回文的。
 * 给你一个整数n，如果n是严格回文的，请返回true，否则返回false。如果一个字符串从前往后读和从后往前读完全相同，那么这个字符串是回文的。
 * @author CLAY
 */
public class StrictlyPalindromicNumber {
    public static void main(String[] args) {
        System.out.println(isStrictlyPalindromic(4));
        System.out.println(isStrictlyPalindromic(123));
        System.out.println(isStrictlyPalindromic(1234));
        System.out.println(isStrictlyPalindromic(12345));
    }

    public static boolean isStrictlyPalindromic(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean flag = false;
        for (int i = 2; i <= n - 2; i++) {
            String baseConversion = getBaseConversion(n, i, stringBuffer);
            if (baseConversion.equals(stringBuffer.reverse().toString())){
                flag = true;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static String getBaseConversion(int n, int base , StringBuffer result){
        if (n / base == 0){
            return result.append(1).reverse().toString();
        }else {
            return getBaseConversion(n / base, base, result.append(n % base) );
        }
    }
}
