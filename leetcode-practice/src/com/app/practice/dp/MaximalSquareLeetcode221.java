package com.app.practice.dp;

public class MaximalSquareLeetcode221 {
	private static int maximalSquare(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];

		int maxWidth = -1;
		for(int i = 0; i < m; i++) {
			if(matrix[i][0] == 1) {
				dp[i][0] = 1;
				maxWidth = dp[i][0];
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(matrix[0][i] == 1) {
				dp[0][i] = 1;
				maxWidth = dp[0][i];
			}
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(matrix[i][j] == 1) {
					int option1 = dp[i - 1][j];
					int option2 = dp[i][j - 1];
					int option3 = dp[i - 1][j - 1];
					dp[i][j] = 1 + Integer.min(option1, Integer.min(option2, option3));
					maxWidth = Integer.max(maxWidth, dp[i][j]);
				}
			}
		}
		
		return maxWidth;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
		int ans = maximalSquare(matrix);
		System.out.println(ans);
	}

}
