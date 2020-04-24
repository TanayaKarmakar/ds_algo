package com.app.questions;

public class MaximalRectangleLeetcode85 {
	public static int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];

		int width = 0;
		int maxArea = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = (j == 0 ? 1 : 1 + dp[i][j - 1]);
					width = dp[i][j];

					for (int k = i; k >= 0; k--) {
						width = Integer.min(width, dp[k][j]);
						maxArea = Integer.max(maxArea, width * (i - k + 1));
					}
				}
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		
		int maxArea = maximalRectangle(matrix);
		
		System.out.println(maxArea);

	}

}
