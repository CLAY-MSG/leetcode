package com.clay;

import java.util.*;

/**
 * 如果我们可以将小写字母插入模式串pattern得到待查询项query，那么待查询项与给定模式串匹配。
 * （我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * 给定待查询列表queries，和模式串pattern，返回由布尔值组成的答案列表answer。只有在待查项queries[i]
 * 与模式串pattern 匹配时，answer[i]才为 true，否则为 false。
 * @author CLAY
 */
public class CamelcaseMatching {
    public static void main(String[] args) {
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";

//        System.out.println(Arrays.toString(strToStrArray(pattern)));
        System.out.println(camelMatch(queries, pattern));

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
                    if(!(kmp(queryArray[j],patternArray[j]))){
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

    public static boolean kmp(String s1, String s2){
        return s1.contains(s2);
    }
}
