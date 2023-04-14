package com.clay;

import java.util.HashMap;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class MostOfTheElements {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new MostOfTheElements().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)){
                hashMap.put(num,1);
            }else {
                hashMap.put(num,hashMap.get(num) + 1);
            }
        }
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) > (nums.length / 2)){
                return integer;
            }
        }
        return 0;
    }
}
