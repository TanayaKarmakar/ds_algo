package com.app.dp1.problems;

public class MinCostToReachEndBottomUp {
	private static int minCost(int[][] steps, int m, int n) {
		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = steps[m - 1][n - 1];
		for(int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = steps[i][n - 1] + dp[i + 1][n - 1];
		}
		
		for(int i = n - 2; i >= 0; i--) {
			dp[m - 1][i] = steps[m - 1][i] + dp[m - 1][i + 1];
		}
		
		for(int i = m - 2; i >= 0; i--) {
			for(int j = n - 2; j >= 0; j--) {
				dp[i][j] = steps[i][j] + Integer.min(dp[i + 1][j + 1], 
						Integer.min(dp[i + 1][j], dp[i][j + 1]));
			}
		}
		
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] steps = { { 4, 3, 2 }, { 1, 8, 3 }, { 1, 1, 8 } };
		int minCost = minCost(steps, 3, 3);
		
		System.out.println("MinCost - " + minCost);

	}

}
