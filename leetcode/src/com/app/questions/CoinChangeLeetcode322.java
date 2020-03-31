package com.app.questions;

import java.util.Arrays;

public class CoinChangeLeetcode322 {
	private static int minCoinChange(int[] coins, int amount) {
		int n = coins.length;

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int j = 1; j <= amount; j++) {
			for (int i = 0; i < n; i++) {
				if (j >= coins[i]) {
					int subRes = dp[j - coins[i]];
					if(subRes != Integer.MAX_VALUE) {
						dp[j] = Integer.min(dp[j], subRes + 1);
					}	
				}
			}
		}

		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };

		int minCoins = minCoinChange(coins, 11);

		System.out.println(minCoins);
		
		coins = new int[] {2};
		
		minCoins = minCoinChange(coins, 3);
		
		System.out.println(minCoins);
	}

}
