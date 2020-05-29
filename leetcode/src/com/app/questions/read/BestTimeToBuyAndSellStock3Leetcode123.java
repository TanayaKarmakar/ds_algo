package com.app.questions.read;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock3Leetcode123 {
	private static int maxProfit(int[][][] memo, int[] profits, int currentIndx, int k, int onGoing) {
		if (currentIndx == profits.length)
			return 0;
		if (memo[currentIndx][k][onGoing] == -1) {
			int option1 = maxProfit(memo, profits, currentIndx + 1, k, onGoing);
			int option2 = 0;
			if (onGoing == 1) {
				if (k > 0) {
					option2 = maxProfit(memo, profits, currentIndx + 1, k - 1, 0) + profits[currentIndx];
				}
			} else {
				option2 = maxProfit(memo, profits, currentIndx + 1, k, 1) - profits[currentIndx];
			}
			memo[currentIndx][k][onGoing] = Integer.max(option1, option2);
		}
		return memo[currentIndx][k][onGoing];
	}

	private static int maxProfit(int[] profits) {
		int n = profits.length;
		int k = 2;
		int[][][] memo = new int[n][k + 1][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}

		return maxProfit(memo, profits, 0, k, 0);
	}

	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int maxProfit = maxProfit(prices);

		System.out.println(maxProfit);

		prices = new int[] { 1, 2, 3, 4, 5 };

		maxProfit = maxProfit(prices);

		System.out.println(maxProfit);

		prices = new int[] { 7, 6, 4, 3, 1 };
		
		maxProfit = maxProfit(prices);

		System.out.println(maxProfit);
	}

}
