package com.app.questions.junechallenge;

public class CoinChange2Leetcode518 {
	private static int coinChangeTabulation(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n][amount + 1];
		
		for(int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= amount; j++) {
				dp[i][j] = dp[i - 1][j];
				if(j >= coins[i]) {
					dp[i][j] += dp[i][j - coins[i]];
				}
			}
		}
		
		return dp[n - 1][amount];
	}
	
	private static int coinChangeHelper(Integer[][] memo, int[] coins, int amount, int indx) {
		if(amount == 0)
			return 1;
		if(indx >= coins.length)
			return 0;
		if(memo[indx][amount] == null) {
			int c1 = coinChangeHelper(memo, coins, amount, indx + 1);
			int c2 = 0;
			if(amount >= coins[indx]) {
				c2 = coinChangeHelper(memo, coins, amount - coins[indx], indx);
			}
			memo[indx][amount] = c1 + c2;
		}
		return memo[indx][amount];
	}
	
	private static int coinChange(int[] coins, int amount) {
		int n = coins.length;
		Integer[][] memo = new Integer[n][amount + 1];
		return coinChangeHelper(memo, coins, amount, 0);
	}

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 5;
		
		System.out.println(coinChange(coins, amount));
		System.out.println(coinChangeTabulation(coins, amount));
		
		coins = new int[] {2};
		amount = 3;
		
		System.out.println(coinChange(coins, amount));
		System.out.println(coinChangeTabulation(coins, amount));
	}

}
