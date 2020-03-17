package com.app.dynamicprogramming.classroom;

import java.util.Arrays;

public class MinimumCoinChangeDPCodingNinjas {
	private static int totalNumberOfWays(int n, int[] coins, int k, int[][] dp, int startIndx) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (k == 0)
			return 0;
		if (dp[n][k] >= 0)
			return dp[n][k];

		int option1 = totalNumberOfWays(n - coins[startIndx], coins, k, dp, startIndx);
		int option2 = totalNumberOfWays(n, coins, k - 1, dp, startIndx + 1);
		dp[n][k] = option1 + option2;
		return dp[n][k];

	}

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		int[] coins = { 1, 2 };
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}

		int numWays = totalNumberOfWays(n, coins, k, dp, 0);
		System.out.println("Number of Ways - " + numWays);
	}

}
