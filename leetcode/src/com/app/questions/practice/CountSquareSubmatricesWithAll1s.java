package com.app.questions.practice;

import java.util.Arrays;

public class CountSquareSubmatricesWithAll1s {
	private static int countSquares(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int count = 0;

		int[][] dp = new int[m][n];
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 1) {
				dp[0][i] = 1;
				count++;
			}
		}

		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 1) {
				dp[i][0] = 1;
				count++;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 1) {
					dp[i][j] = 1 + Integer.min(dp[i - 1][j], Integer.min(dp[i][j - 1], dp[i - 1][j - 1]));
					count += dp[i][j];
				}
			}
		}

		//System.out.println(Arrays.deepToString(dp));
		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		int count = countSquares(matrix);

		System.out.println(count);

		matrix = new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		count = countSquares(matrix);

		System.out.println(count);
	}

}
