package com.clay;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1023. 驼峰式匹配
 * 如果我们可以将小写字母插入模式串pattern得到待查询项query，那么待查询项与给定模式串匹配。
 * （我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * 给定待查询列表queries，和模式串pattern，返回由布尔值组成的答案列表answer。只有在待查项queries[i]
 * 与模式串pattern 匹配时，answer[i]才为 true，否则为 false。
 * @author CLAY
 */
public class CamelcaseMatching {
    public static void main(String[] args) {
        String[] queries = {"CompetitiveProgramming","CounterPick","ControlPanel"};
        String pattern = "CooP";

//        System.out.println(Arrays.toString(strToStrArray(pattern)));
        System.out.println(camelMatch2(queries, pattern));

    }
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        String[] patternArray = strToStrArray(pattern);
        String[] queryArray;
        String query;
        boolean flag = true;
        List<Boolean> resultList= new ArrayList<>() ;
        for (int i = 0; i < queries.length; i++) {
            query = queries[i];
            queryArray = strToStrArray(query);
            if (patternArray.length != queryArray.length){
                resultList.add(i,false);
            }else {
                for (int j = 0; j < patternArray.length; j++) {
                    if(!(isContains(queryArray[j],patternArray[j]))){
                        flag = false;
                        break;
                    }
                }
                resultList.add(i,flag);
                flag = true;
            }
        }
        return resultList;
    }

    public static String[] strToStrArray(String str){
        String s = str.replaceAll("[A-Z]", "_$0");
        String[] s1 = s.split("_");
        String[] strings = new String[s1.length - 1];
        int index = 0;
        for (int i = 1; i < s1.length; i++) {
            strings[index] = s1[i];
            index++;
        }
        return strings;
    }

    public static boolean isContains(String s1, String s2){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            char c2 = s2.charAt(i);
            for (int j = i; j < s1.length(); j++) {
                char c1 = s1.charAt(j);
                if (c2 == c1){
                    stringBuilder.append(c1);
                    break;
                }
            }
        }
        return stringBuilder.toString().equals(s2);
    }

    public static List<Boolean> camelMatch2(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (var q : queries) {
            ans.add(check(q, pattern));
        }
        return ans;
    }

    private static boolean check(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        for (; j < n; ++i, ++j) {
            while (i < m && s.charAt(i) != t.charAt(j) && Character.isLowerCase(s.charAt(i))) {
                ++i;
            }
            if (i == m || s.charAt(i) != t.charAt(j)) {
                return false;
            }
        }
        while (i < m && Character.isLowerCase(s.charAt(i))) {
            ++i;
        }
        return i == m;
    }
}
