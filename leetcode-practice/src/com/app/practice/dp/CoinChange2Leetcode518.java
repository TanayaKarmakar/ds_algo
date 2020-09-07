package com.app.practice.dp;

public class CoinChange2Leetcode518 {
	private static int change(int amount, int[] coins) {
		if (coins.length == 0) {
			if (amount == 0)
				return 1;
			return 0;
		}
		int n = coins.length;
		int[][] dp = new int[n][amount + 1];
		dp[0][0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (i - 1 >= 0)
					dp[i][j] = dp[i - 1][j];
				if (j >= coins[i])
					dp[i][j] += dp[i][j - coins[i]];
			}
		}
		return dp[n - 1][amount];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 5;

		int ans = change(amount, coins);

		System.out.println(ans);
	}

}
