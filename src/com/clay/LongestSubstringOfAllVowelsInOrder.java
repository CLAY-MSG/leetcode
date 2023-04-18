package com.clay;

import java.util.*;

/**
 * 1839. 所有元音按顺序排布的最长子字符串
 * 当一个字符串满足如下条件时，我们称它是 美丽的 ：
 * 所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
 * 这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
 * 比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
 * 给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
 * 子字符串 是字符串中一个连续的字符序列。
 * @author CLAY
 */
public class LongestSubstringOfAllVowelsInOrder {
    public static void main(String[] args) {
        String word = "aaeioeuu";
//        System.out.println(longestBeautifulSubstring(word));
        System.out.println(longestBeautifulSubstring(word));
    }

    public static int longestBeautifulSubstring(String word) {
        if (word == null || word.length() < 5){
            return 0;
        }

        if (word.length() == 5){
            if ("aeiou".equals(word)){
                return 5;
            }else {
                return 0;
            }
        }

        int from = 0;
        int end = 0;
        int max = 0;
        String str;
        while (end < word.length()){
            if (word.charAt(from) != 'a' ){
                for (int i = from; i < word.length(); i++) {
                    if (word.charAt(i) == 'a'){
                        from = i;
                        break;
                    }
                }
            }
            end = from;
            while (end + 1 < word.length()) {
                if ((word.charAt(end + 1) != 'u' && word.charAt(end) == 'u') ||
                        (word.charAt(end + 1) == 'a' && word.charAt(end) != 'a')){
                    if (end - from + 1 >= 5){
                        if (word.charAt(end) == 'u'){
                            str = word.substring(from, end + 1);
                            String newStr = strDistinct(str);
                            if (newStr.contains("aeiou")){
                                max = Math.max(max, str.length());
                            }
                        }
                    }
                    end = end + 1;

                    if (end + 5 > word.length()){
                        return max;
                    }
                    break;
                }
                end++;

            }

            if (end + 1 == word.length()){
                str = word.substring(from);
                String newStr = strDistinct(str);
                if (newStr.contains("aeiou")){
                    return max = Math.max(max, str.length());
                }else {
                    return max;
                }
            }else {
                from = end;
            }
        }

        return max;
    }

    public static String strDistinct(String str){
        List<Character> vowels = new ArrayList<>();

        char pre = str.charAt(0);
        vowels.add(pre);
        for (int i = 0; i + 1 < str.length(); i++) {
            pre = str.charAt(i);
            char cur = str.charAt(i + 1);
            if (cur!= pre){
                vowels.add(str.charAt(i + 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        vowels.forEach(sb::append);
        return sb.toString();
    }

    public int longestBeautifulSubstring2(String word) {
        char prev = 'x';
        int max = 0;
        int now = 0;
        char[] chs = word.toCharArray();
        for(int i = 0; i < word.length(); i++){
            switch(chs[i]){
                case 'a':
                    if(prev != 'a'){
                        now = 1;
                    }else{
                        now++;
                    }
                    break;
                case 'e':
                    if((prev != 'a' && prev != 'e') || now == 0){
                        now = 0;
                    }else{
                        now++;
                    }
                    break;
                case 'i':
                    if((prev != 'e' && prev != 'i') || now == 0){
                        now = 0;
                    }else{
                        now++;
                    }
                    break;
                case 'o':
                    if((prev != 'i' && prev != 'o') || now == 0){
                        now = 0;
                    }else{
                        now++;
                    }
                    break;
                case 'u':
                    if((prev != 'o' && prev != 'u') || now == 0){
                        now = 0;
                    }else{
                        now++;
                    }
                    max = Math.max(now,max);
                    break;
                default:
                    now = 0;
                    break;
            }
            prev = chs[i];
        }
        return max;
    }

    public int longestBeautifulSubstring3(String word) {
        int ans = 0, type = 1, len = 1;
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) >= word.charAt(i-1)) {
                len++; //更新当前字符串长度
            }
            if(word.charAt(i) > word.charAt(i-1)) {
                type++; //更新当前字符种类
            }
            if(word.charAt(i) < word.charAt(i-1)) {
                type = 1; len = 1;//当前字符串不美丽，从当前字符重新开始
            }
            if(type == 5) {
                ans = Math.max(ans, len);  //更新最大字符串
            }
        }
        return ans;
    }

}
