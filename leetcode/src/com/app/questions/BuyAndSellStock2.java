package com.app.questions;

public class BuyAndSellStock2 {
	private static int maxProfit(int[] prices) {
		int n = prices.length;
		int start = -1;
		int end = -1;
		int profit = 0;
		int i = 0;
		while (i < n) {
			while (i + 1 < n && prices[i] > prices[i + 1])
				i++;
			start = i++;

			while (i + 1 < n && prices[i] < prices[i + 1])
				i++;
			end = i++;

			if (start < n && end < n) {
				profit += (prices[end] - prices[start]);
			}

		}

		return profit;
	}

	public static void main(String[] args) {
		System.out.println("Max Profit - " + maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println("Max Profit - " + maxProfit(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println("Max Profit - " + maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

}
