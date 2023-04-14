package com.clay;

/**
 * 121.买卖股票的最佳时机
 *
 * @author MSG
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }

    public static int maxProfit(int[] prices) {
        /*int currMaxProfit = 0;
        for (int i = 0, j = 0; j < prices.length; j++) {
            if (prices[j] - prices[i] < 0) {
                i = j;
            } else {
                currMaxProfit = Math.max(prices[j] - prices[i], currMaxProfit);
            }
        }
        return currMaxProfit;*/
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                maxProfit = Math.max(price - min, maxProfit);
            }
        }
        return maxProfit;
    }
}
