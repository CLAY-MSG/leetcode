package com.clay;

/**
 * 53.最大子序和
 *
 * @author MSG
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-1};
//        int[] nums = {1, -1, -2};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int preSubArray = 0;
        int maxSubArraySum = nums[0];
        for (int x : nums) {
            preSubArray = Math.max(preSubArray + x, x);
            maxSubArraySum = Math.max(maxSubArraySum, preSubArray);
        }
        return maxSubArraySum;
    }
}
