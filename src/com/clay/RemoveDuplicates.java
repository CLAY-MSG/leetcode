package com.clay;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 26.删除数组中的重复项
 * @author MSG
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
//        int[] nums = {1,3,3,5,6,7,7,8,8,9};
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    public static int removeDuplicates(int[] nums){
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[j] != nums [i]){
                j++;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }
}
