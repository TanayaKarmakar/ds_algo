package com.app.practice;

import java.util.Arrays;

public class MinimumCoinChangeLeetcode322 {
	private static int coinChange(int[] coins, int amount) {
		if(coins.length == 0)
			return 0;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		int n = coins.length;

		dp[0] = 0;

		for (int j = 0; j <= amount; j++) {
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

		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };

		int minCoinChange = coinChange(coins, 11);

		System.out.println(minCoinChange);

		coins = new int[] { 2 };

		minCoinChange = coinChange(coins, 3);

		System.out.println(minCoinChange);

	}

}
