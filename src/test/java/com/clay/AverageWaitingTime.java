package com.clay;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 1701. 平均等待时间
 * 有一个餐厅，只有一位厨师。你有一个顾客数组 customers ，其中 customers[i] = [arrivali, timei] ：
 * arrivali 是第 i 位顾客到达的时间，到达时间按 非递减 顺序排列。
 * timei 是给第 i 位顾客做菜需要的时间。
 * 当一位顾客到达时，他将他的订单给厨师，厨师一旦空闲的时候就开始做这位顾客的菜。每位顾客会一直等待到厨师完成他的订单。厨师同时只能做一个人的订单。厨师会严格按照 订单给他的顺序 做菜。
 * 请你返回所有顾客需要等待的 平均 时间。与标准答案误差在 10-5 范围以内，都视为正确结果。
 * @author CLAY
 */
public class AverageWaitingTime {
    public static void main(String[] args) {
        int[][] customers= {{2, 3}, {6, 3}, {7, 5}, {11, 3}, {15, 2}, {18, 1}};
        System.out.println(averageWaitingTime(customers));
    }

    public static double averageWaitingTime(int[][] customers) {
        int sum = 0;
        long timeSum = 0;
        for (int i = 0; i < customers.length; i++) {
            int[] customer = customers[i];
            if (i == 0){
                timeSum += customer[1];
                sum = customer[0] + customer[1];
            }else {
                if (customer[0] < sum ){
                    timeSum += sum - customer[0] + customer[1];
                    sum += customer[1];
                } else {
                    timeSum += customer[1];
                    sum = customer[0] + customer[1];
                }
            }
        }
        double v = (double) timeSum / customers.length;
        String format = String.format("%.5f", v);
        return Double.parseDouble(format);



    }
}
