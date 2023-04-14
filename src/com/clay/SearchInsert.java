package com.clay;

/**
 * 37.搜索插入位置
 * @author MSG
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,7};
        System.out.println(searchInsert(nums,0));
    }

    public static int searchInsert(int[] nums, int target){
        if (target < nums[0]){
            return 0;
        }
        if (target > nums[nums.length - 1]){
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target){
                return i;
            }
            if (nums[i] < target && nums[i + 1] > target){
                return i + 1;
            }
        }
        return -1;
    }
}
