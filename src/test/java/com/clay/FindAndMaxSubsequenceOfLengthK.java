package com.clay;

import java.util.*;

/**
 * 2099. 找到和最大的长度为 K 的子序列
 * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
 *
 * 请你返回 任意 一个长度为 k 的整数子序列。
 *
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 *
 *
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */



public class FindAndMaxSubsequenceOfLengthK {
    public static void main(String[] args) {
        int[] nums = {-16,-13,8,16,35,-17,30,-8,34,-2,-29,-35,15,13,-30,-34,6,15,28,-23,34,28,-24,15,-17,10,31,32,-3,-36,19,31,-5,-21,-33,-18,-23,-37,-15,12,-28,-40,1,38,38,-38,33,-35,-28,-40,4,-15,-29,-33,-18,-9,-29,20,1,36,-8,23,-34,16,-7,13,39,38,7,-7,-10,30,9,26,27,-37,-18,-25,14,-36,23,28,-15,35,-9,1};
        Arrays.stream(new FindAndMaxSubsequenceOfLengthK().maxSubsequence(nums, 8)).forEach(System.out::println);
    }

    public int[] maxSubsequence(int[] nums, int k) {
        if (nums.length == k){
            return nums;
        }
        int[] copyNums = new int[nums.length];
        System.arraycopy(nums, 0, copyNums, 0, nums.length);
        Arrays.sort(copyNums);
        List<Integer> numsList = new ArrayList<>();
        int[] reNums = new int[k];
        int j = 0;
        int startIndex = nums.length - k;
        for (int i = startIndex; i < copyNums.length; i++) {
            numsList.add(copyNums[i]);
        }
        for (int num : nums) {
            if (numsList.contains(num)) {
                numsList.remove((Integer) num);
                reNums[j] = num;
                j++;
            }
            if (j >= k) {
                break;
            }
        }
        return reNums;
    }
}
