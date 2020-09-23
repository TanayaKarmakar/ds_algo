package com.app.practice.dp;

import java.util.Arrays;

public class CountSquareSubmatricesLeetcode1277 {
	private static int countSquares(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					if (i == 0 || j == 0) {
						dp[i][j] = matrix[i][j];
					} else {
						int option1 = dp[i - 1][j - 1];
						int option2 = dp[i - 1][j];
						int option3 = dp[i][j - 1];
						dp[i][j] = 1 + Integer.min(option1, Integer.min(option2, option3));
					}
					count += dp[i][j];
				}
			}
		}
		
		System.out.println(Arrays.deepToString(dp));

		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		
		int ans = countSquares(matrix);
		
		System.out.println(ans);

	}

}
