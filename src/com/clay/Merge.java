package com.clay;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 88.合并两个有序数组
 *
 * @author MSG
 */
public class Merge {
    public static void main(String[] args) {
//        nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < m + n) {
            nums1 = Arrays.copyOf(nums1, m + n);
        }
        /*int index = 0;
        for (int i = m; i < nums1.length; i++) {
                nums1[i] = nums2[index++];
        }*/


        /*for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums1[i] > nums1[j]){
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }*/

        /*System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));*/


        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0)) {
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

        System.out.println(Arrays.toString(nums1));
    }

}
