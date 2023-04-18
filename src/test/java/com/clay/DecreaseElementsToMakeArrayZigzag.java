package com.clay;

/**
 * 1144. 递减元素使数组呈锯齿状
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * @author CLAY
 */
public class DecreaseElementsToMakeArrayZigzag {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 1};
        System.out.println(movesToMakeZigzag(nums));
        System.out.println(movesToMakeZigzag2(nums));
    }

    public static int movesToMakeZigzag(int[] nums) {
        int oddIsMin = oddIsMin(nums);
        int oddIsMax = oddIsMax(nums);
        return Math.min(oddIsMin, oddIsMax);
    }

    public static int oddIsMin(int[] nums){
        int count = 0;
        int pre = 0;
        int cur;
        int next;

        for (int i = 1; i < nums.length; i++) {
            pre = nums[i - 1];
            cur = nums[i];
            next = 0;
            if (i < nums.length - 1) {
                next = nums[i + 1];
            }
            if (i % 2 != 0) {
                if (i == nums.length - 1){
                    if (cur >= pre) {
                        count = count + cur - pre + 1;
                    }
                    break;
                }
                int min = Math.min(pre, next);
                if (min <= cur) {
                    count = count + cur - min + 1;
                }
            }

        }
        return count;
    }

    public static int oddIsMax(int[] nums){
        int count = 0;
        int pre = 0;
        int cur;
        int next;

        for (int i = 0; i < nums.length; i++) {
            if ( i > 0 ) {
                pre = nums[i - 1];
            }
            cur = nums[i];
            next = 0;

            if (i < nums.length - 1) {
                next = nums[i + 1];
            }

            if(i % 2 == 0) {
                if (i == 0){
                    if (cur >= next) {
                        count = count + cur - next + 1;
                    }
                }else if (i == nums.length - 1){
                    if (cur >= pre) {
                        count = count + cur - pre + 1;
                    }
                }else{
                    int min = Math.min(pre, next);
                    if (min <= cur){
                        count = count + cur - min + 1;
                    }
                }
            }
        }
        return count;
    }
    public static int movesToMakeZigzag2(int[] nums) {
    return Math.min(help(nums, 0), help(nums, 1));
}

    public static int help(int[] nums, int pos) {
        int res = 0;
        for (int i = pos; i < nums.length; i += 2) {
            int a = 0;
            if (i - 1 >= 0) {
                a = Math.max(a, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                a = Math.max(a, nums[i] - nums[i + 1] + 1);
            }
            res += a;
        }
        return res;
    }

}
