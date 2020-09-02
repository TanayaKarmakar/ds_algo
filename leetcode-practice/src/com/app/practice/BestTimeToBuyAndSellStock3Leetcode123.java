package com.app.practice;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock3Leetcode123 {
	private static int maxProfit(int[][][] memo, int[] prices, int k, int indx, int onGoing) {
		if (indx >= prices.length)
			return 0;
		if (memo[indx][k][onGoing] == -1) {
			int option1 = maxProfit(memo, prices, k, indx + 1, onGoing);
			int option2 = 0;
			if (onGoing == 1) {
				if (k > 0) {
					option2 = maxProfit(memo, prices, k - 1, indx + 1, 0) + prices[indx];
				}
			} else {
				option2 = maxProfit(memo, prices, k, indx + 1, 1) - prices[indx];
			}
			memo[indx][k][onGoing] = Integer.max(option1, option2);
		}
		return memo[indx][k][onGoing];
	}

	private static int maxProfit(int[] prices, int k) {
		int n = prices.length;
		int[][][] memo = new int[n][k + 1][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		return maxProfit(memo, prices, k, 0, 0);
	}

	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int maxProfit = maxProfit(prices, 2);

		System.out.println(maxProfit);

		prices = new int[] { 1, 2, 3, 4, 5 };

		maxProfit = maxProfit(prices, 2);

		System.out.println(maxProfit);

		prices = new int[] { 7, 6, 4, 3, 1 };
		
		maxProfit = maxProfit(prices, 2);

		System.out.println(maxProfit);
	}

}
