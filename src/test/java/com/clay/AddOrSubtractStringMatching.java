package com.clay;

import java.util.Arrays;

/**
 * 942. 增减字符串匹配
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class AddOrSubtractStringMatching {
    public static void main(String[] args) {
        String s = "DDI";
        Arrays.stream(new AddOrSubtractStringMatching().diStringMatch(s)).forEach(System.out::println);
    }

    public int[] diStringMatch(String s) {
        int min = 0;
        int length = s.length() + 1;
        int max = length - 1;
        int[] nums = new int[length];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'I'){
                nums[i] = min;
                min++;
                if (i == chars.length - 1){
                    nums[i + 1] = min;
                }
            }else if (c == 'D'){
                nums[i] = max;
                max--;
                if (i == chars.length - 1){
                    nums[i + 1] = max;
                }
            }
        }
        return nums;
    }

}
