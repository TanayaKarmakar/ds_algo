package com.app.questions.practice;

public class MaximalRectangleLeetcode85 {
	private static int maxArea(char[][] grid) {
		if(grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];

		int maxArea = 0;
		int width = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					dp[i][j] = j == 0? 1: 1 + dp[i][j - 1];
					width = dp[i][j];

					for (int k = i; k >= 0; k--) {
						width = Integer.min(width, dp[k][j]);
						int height = (i - k) + 1;
						maxArea = Integer.max(maxArea, width * height);
					}
				}
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		
		int maxArea = maxArea(grid);
		
		System.out.println(maxArea);
	}

}
