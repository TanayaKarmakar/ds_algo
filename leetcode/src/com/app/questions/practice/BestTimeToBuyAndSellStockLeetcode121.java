package com.app.questions.practice;

public class BestTimeToBuyAndSellStockLeetcode121 {
	private static int maxProfit(int[] prices) {
		int n = prices.length;
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (minPrice > prices[i]) {
				minPrice = prices[i];
			}
			int diff = prices[i] - minPrice;
			maxProfit = Integer.max(diff, maxProfit);
		}
		if (maxProfit < 0 || maxProfit == Integer.MIN_VALUE) {
			maxProfit = 0;
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		int maxProfit = maxProfit(prices);
		
		System.out.println(maxProfit);

	}

}
