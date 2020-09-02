package com.app.practice.dp;

public class MaximalRectangleLeetcode85 {
	private static int maximalRectangle(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];

		dp[0][0] = grid[0][0] - '0';

		int width = 0;
		int maxArea = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					dp[i][j] = (j == 0) ? 1 : 1 + dp[i][j - 1];
					width = dp[i][j];

					for (int k = i; k >= 0; k--) {
						int height = (i - k) + 1;
						width = Integer.min(width, dp[k][j]);
						maxArea = Integer.max(maxArea, height * width);
					}
				}
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, 
				{ '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		
		int maxArea = maximalRectangle(grid);
		
		System.out.println(maxArea);

	}

}
