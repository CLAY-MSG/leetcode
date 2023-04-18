package com.clay;

import java.util.ArrayList;
import java.util.List;

/**
 * 119.杨辉三角2
 *
 * @author MSG
 */
public class YanghuiTriangle2 {
    public static void main(String[] args) {
        System.out.println(generate(3));

    }

    /*[
            [1],
            [1,1],
            [1,2,1],
            [1,3,3,1],
            [1,4,6,4,1]
    ]*/

    public static List<Integer> generate(int k) {

        /*List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            if (i == 0 || i == 1){
                int j = i;
                while (j >= 0){
                    integers.add(1);
                    j--;
                }
            }else {
                List<Integer> integers1 = lists.get(i - 1);
                integers.add(0, integers1.get(0));
                for (int j = 1; j < i; j++) {
                    integers.add(j,integers1.get(j - 1) + integers1.get(j));
                }
                integers.add(i, integers1.get(i - 1));
            }
            lists.add(integers);
        }
        return lists;*/


        /*List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    integers.add(1);
                } else {
                    integers.add(j, lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
            lists.add(integers);
        }
        return lists.get(lists.size() - 1);*/

        ArrayList<Integer> tempIntegers = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < k + 1; i++) {
            integers = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i){
                    integers.add(1);
                }else {
                    integers.add(j, tempIntegers.get(j - 1) + tempIntegers.get(j));
                }
            }
            tempIntegers = integers;
        }
        return integers;
    }
}
