package com.clay;


/**
 * 540. 有序数组中的单一元素
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class ASingleElementInAnOrderedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int low = 0;
        int high = nums.length - 1;

        while (low < high){
            int mid = (low + high) / 2;
            if (nums[mid] == nums[mid ^ 1]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(nums[low]);
    }
}