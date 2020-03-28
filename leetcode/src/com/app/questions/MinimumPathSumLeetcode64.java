package com.app.questions;

public class MinimumPathSumLeetcode64 {
	private static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = grid[m - 1][n - 1];
		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = grid[i][n - 1] + dp[i + 1][n - 1];
		}

		for (int i = n - 2; i >= 0; i--) {
			dp[m - 1][i] = grid[m - 1][i] + dp[m - 1][i + 1];
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = Integer.min(dp[i + 1][j],dp[i][j + 1]) + grid[i][j];
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		int minCost = minPathSum(grid);
		
		System.out.println(minCost);
	}

}
