package com.clay;

/**
 * 53.最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class TheLargestSubarraySum {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new TheLargestSubarraySum().maxSubArray(nums));
        System.out.println(new TheLargestSubarraySum().maxSubArray2(nums));
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }
    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


}
