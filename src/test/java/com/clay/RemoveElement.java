package com.clay;

import java.util.Arrays;

/**
 * 27.移除元素
 * @author MSG
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums,3));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val){
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j ;
    }
}
