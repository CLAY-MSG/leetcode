package com.clay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class TheOldestStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new TheOldestStringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int maxSize = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()){
            if (!set.contains(chars[right])){
                set.add(chars[right]);
                right++;
                maxSize = Math.max(maxSize, right - left);
            }else {
                set.remove(chars[left]);
                left++;
            }
        }
        return maxSize;
    }
}
