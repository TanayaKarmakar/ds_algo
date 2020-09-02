package com.app.practice;

public class BestTimeToBuyAndSellStocks2Leetcode122 {
	private static int maxProfit(int[] prices) {
		int n = prices.length;
		int i = 0;
		int maxProfit = 0;
		while (i < n) {
			while (i + 1 < n && prices[i] > prices[i + 1]) {
				i++;
			}

			int start = i++;

			while (i + 1 < n && prices[i] < prices[i + 1]) {
				i++;
			}

			int end = i++;
			if(start < n && end < n)
				maxProfit += (prices[end] - prices[start]);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] nums = { 7, 1, 5, 3, 6, 4 };

		int maxProfit = maxProfit(nums);

		System.out.println(maxProfit);

		nums = new int[] { 1, 2, 3, 4, 5 };

		maxProfit = maxProfit(nums);

		System.out.println(maxProfit);

		nums = new int[] { 7, 6, 4, 3, 1 };
		
		maxProfit = maxProfit(nums);

		System.out.println(maxProfit);

	}

}
