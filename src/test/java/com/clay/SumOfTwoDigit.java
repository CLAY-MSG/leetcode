package com.clay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * @author MSG
 */
public class SumOfTwoDigit {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(sumOfTwoDigit(nums, 7)));
    }

    public static int[] sumOfTwoDigit(int[] nums, int target){
        /*int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    ints[0] = i;
                    ints[1] = j;
                }
            }
        }
        return ints;*/

        Map<Integer,Integer> hashVisited = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(hashVisited.containsKey(target - nums[i])){
                int index = hashVisited.get(target - nums[i]);
                return new int[] {index,i};
            }else{
                hashVisited.put(nums[i],i);
            }
        }

        return null;

    }
}
