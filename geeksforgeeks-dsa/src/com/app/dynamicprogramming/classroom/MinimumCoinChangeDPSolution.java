package com.app.dynamicprogramming.classroom;

import java.util.Arrays;

public class MinimumCoinChangeDPSolution {
	private static int getMinCoinChange(int[] coins, int val) {
		int[] dp = new int[val + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		int n = coins.length;
		for (int i = 1; i <= val; i++) {
			for (int j = 0; j < n; j++) {
				if (coins[j] <= i) {
					int subRes = dp[i - coins[j]];
					if (subRes != Integer.MAX_VALUE) {
						dp[i] = Integer.min(dp[i], subRes + 1);
					}
				}
			}
		}
		
		//System.out.println(Arrays.toString(dp));

		return dp[val];
	}

	public static void main(String[] args) {
		int[] coins = { 25, 10, 5 };
		int val = 30;

		int minCoinChange = getMinCoinChange(coins, val);

		System.out.println("MinCoinChange - " + minCoinChange);

	}

}
