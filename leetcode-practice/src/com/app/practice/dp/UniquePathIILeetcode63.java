package com.app.practice.dp;

public class UniquePathIILeetcode63 {
	private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					if (i == 0 || j == 0) {
						if(i == 0 && j == 0)
							dp[i][j] = 1;
						else if(i == 0)
							dp[i][j] = dp[i][j - 1];
						else
							dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					}
				}
			}
		}

		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		
		int count = uniquePathsWithObstacles(matrix);
		
		System.out.println(count);
	}

}
