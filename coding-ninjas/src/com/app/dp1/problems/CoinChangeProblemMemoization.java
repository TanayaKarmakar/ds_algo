package com.app.dp1.problems;

import java.util.Arrays;

public class CoinChangeProblemMemoization {
	private static int numWaysRec(int[][] dp, int[] nums, int total, int startIndx) {
		if(total == 0)
			return 1;
		if(total < 0 || startIndx >= nums.length)
			return 0;
		if(dp[startIndx][total] == -1) {
			int option1 = numWaysRec(dp, nums, total - nums[startIndx], startIndx);
			int option2 = numWaysRec(dp, nums, total, startIndx + 1);
			dp[startIndx][total] = option1 + option2;
		}
		return dp[startIndx][total];
	}
	
	private static int numWays(int[] nums, int total) {
		int n = nums.length;
		int[][] dp = new int[n + 1][total + 1];
		
		for(int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		return numWaysRec(dp, nums, total, 0);
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		int total = 4;
		
		int numWays = numWays(coins, total);
		
		System.out.println(numWays);

	}

}
