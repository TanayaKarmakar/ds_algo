package com.app.practice;

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
						dp[i][j] = 1;
						count++;
					} else {
						int val = 1 + Integer.min(dp[i - 1][j], Integer.min(dp[i - 1][j - 1], dp[i][j - 1]));
						dp[i][j] = val;
						count += val;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		int count = countSquares(matrix);

		System.out.println("Count - " + count);

		matrix = new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		count = countSquares(matrix);

		System.out.println("Count - " + count);

	}

}
