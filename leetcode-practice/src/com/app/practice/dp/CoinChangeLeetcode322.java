package com.app.practice.dp;

import java.util.Arrays;

public class CoinChangeLeetcode322 {
	private static int minCoinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		for (int j = 1; j <= amount; j++) {
			int subRes = Integer.MAX_VALUE;
			for (int i = 0; i < coins.length; i++) {
				if (j >= coins[i]) {
					subRes = Integer.min(subRes, dp[j - coins[i]]);
				}
			}
			if (subRes != Integer.MAX_VALUE)
				dp[j] = Integer.min(dp[j], subRes + 1);
		}

		if (dp[amount] == Integer.MAX_VALUE)
			return -1;
		return dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;

		int ans = minCoinChange(coins, amount);

		System.out.println(ans);

	}

}
