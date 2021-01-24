package com.app.practice.greedy;

public class BestTimeToBuyAndSellStocksLeetcode121 {
	private static int maxProfit(int[] prices) {
		int n = prices.length;
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			minPrice = Integer.min(minPrice, prices[i]);
			maxProfit = Integer.max(maxProfit, prices[i] - minPrice);
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		int[] nums = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = maxProfit(nums);
		
		System.out.println(maxProfit);

	}

}
