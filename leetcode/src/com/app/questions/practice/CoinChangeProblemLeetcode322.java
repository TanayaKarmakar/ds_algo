package com.app.questions.practice;

import java.util.Arrays;

public class CoinChangeProblemLeetcode322 {
	private static int minCoinChange(int[] coins, int total) {
		int[] dp = new int[total + 1];
		int n = coins.length;
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		for (int j = 1; j <= total; j++) {
			int subRes = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (j >= coins[i]) {
					subRes = Integer.min(subRes, dp[j - coins[i]]);
				}
			}
			if (subRes != Integer.MAX_VALUE) {
				dp[j] = Integer.min(dp[j], subRes + 1);
			}
		}

		return dp[total] == Integer.MAX_VALUE ? -1: dp[total];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5 };
		int total = 11;

		int ans = minCoinChange(arr, total);

		System.out.println(ans);

	}

}
