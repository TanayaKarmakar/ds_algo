package com.app.questions.read;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock4Leetcode188 {
	private static int maxProfit(int[][][] memo, int k, int[] profits, int currentIndx, int onGoing) {
		if (currentIndx == profits.length)
			return 0;
		if (memo[currentIndx][k][onGoing] == -1) {
			int option1 = maxProfit(memo, k, profits, currentIndx + 1, onGoing);
			int option2 = 0;
			if (onGoing == 1) {
				if (k > 0) {
					option2 = maxProfit(memo, k - 1, profits, currentIndx + 1, 0) + profits[currentIndx];
				}
			} else {
				option2 = maxProfit(memo, k, profits, currentIndx + 1, 1) - profits[currentIndx];
			}
			memo[currentIndx][k][onGoing] = Integer.max(option1, option2);
		}
		return memo[currentIndx][k][onGoing];
	}

	private static int maxProfit(int k, int[] profits) {
		int n = profits.length;
		int[][][] memo = new int[n][k + 1][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		return maxProfit(memo, k, profits, 0, 0);
	}

	public static void main(String[] args) {
		int[] profits = { 2, 4, 1 };

		int maxProfit = maxProfit(2, profits);

		System.out.println(maxProfit);

		profits = new int[] { 3, 2, 6, 5, 0, 3 };
		
		maxProfit = maxProfit(2, profits);

		System.out.println(maxProfit);

	}

}
