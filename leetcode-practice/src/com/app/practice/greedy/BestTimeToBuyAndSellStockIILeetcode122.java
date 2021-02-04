package com.app.practice.greedy;

public class BestTimeToBuyAndSellStockIILeetcode122 {
    private static int maxProfit(int[] prices) {
        int n = prices.length;

        int i = 0;
        int totalProfit = 0;

        while(i < n) {
            while(i + 1 < n && prices[i] > prices[i + 1]) {
                i++;
            }

            int start = i++;

            while(i + 1 < n && prices[i] < prices[i + 1]) {
                i++;
            }

            int end = i++;

            if(start < n && end < n) {
                totalProfit += (prices[end] - prices[start]);
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};

        int totalProfit = maxProfit(nums);

        System.out.println(totalProfit);
    }
}
