package com.app.practice;

public class MaximalSquareLeetcode221 {
	private static int maximalSquare(int[][] matrix) {
		if(matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;

		int maxSide = 0;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					if (i == 0 || j == 0) {
						dp[i][j] = matrix[i][j];
					} else {
						dp[i][j] = 1 + Integer.min(dp[i - 1][j], 
								Integer.min(dp[i][j - 1], dp[i - 1][j - 1]));
					}
					maxSide = Integer.max(maxSide, dp[i][j]);
				}
			}
		}

		return maxSide * maxSide;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };

		int maxSquare = maximalSquare(matrix);
		
		System.out.println(maxSquare);
	}

}
