package com.app.questions;

public class BestTimeToBuyAndSellStock {
	private static int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = Integer.MIN_VALUE;
		int n = prices.length;

		for (int i = 0; i < n; i++) {
			if (minPrice > prices[i]) {
				minPrice = prices[i];
			}
			if (prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		int maxProfit = maxProfit(prices);

		System.out.println("MaxProfit - " + maxProfit);

		prices = new int[] { 7, 6, 4, 3, 1 };

		maxProfit = maxProfit(prices);

		System.out.println("MaxProfit - " + maxProfit);

		prices = new int[] { 2, 1, 2, 1, 0, 1, 2 };
		
		maxProfit = maxProfit(prices);

		System.out.println("MaxProfit - " + maxProfit);

	}

}
