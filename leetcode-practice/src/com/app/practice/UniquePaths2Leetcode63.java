package com.app.practice;

public class UniquePaths2Leetcode63 {
	private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] dp = new int[m][n];

		dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

		for (int i = 1; i < n; i++) {
			if (obstacleGrid[0][i] == 0) {
				dp[0][i] = dp[0][i - 1];
			}
		}

		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 0) {
				dp[i][0] = dp[i - 1][0];
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int numPath = uniquePathsWithObstacles(obstacleGrid);
		
		System.out.println(numPath);
	}

}
