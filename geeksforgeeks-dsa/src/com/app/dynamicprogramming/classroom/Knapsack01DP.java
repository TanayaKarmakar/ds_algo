package com.app.dynamicprogramming.classroom;

public class Knapsack01DP {
	private static int knapSack(int[] values, int[] weights, int targetWeight, int len) {
		int[][] dp = new int[len + 1][targetWeight + 1];

		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= targetWeight; j++) {
				if (weights[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Integer.max(dp[i - 1][j], 
							values[i - 1] + dp[i - 1][j - weights[i - 1]]);
				}
			}
		}

		return dp[len][targetWeight];
	}

	public static void main(String[] args) {
		int[] weights = { 5, 4, 6, 3 };
		int[] values = { 10, 40, 30, 50 };
		int targetWeight = 10;
		int len = weights.length;
		
		int maxValue = knapSack(values, weights, targetWeight, len);
		
		System.out.println("MaxValue - " + maxValue);

	}

}
