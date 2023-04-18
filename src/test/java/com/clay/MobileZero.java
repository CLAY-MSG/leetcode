package com.clay;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class MobileZero {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MobileZero().moveZeroes(nums);

    }

    public void moveZeroes(int[] nums) {
        ArrayList<Integer> li = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                li.add(num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < li.size()){
                nums[i] = li.get(i);
            }else {
                nums[i] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
