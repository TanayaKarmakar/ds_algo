package com.app.practice;

import java.util.Arrays;

public class ZeroOneMatrixLeetcode542 {
	private static int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] != 0) {
					if (i == 0 && j == 0) {
						dp[i][j] = 10000;
					} else if (i == 0) {
						dp[i][j] = 1 + matrix[i][j - 1];
					} else if (j == 0) {
						dp[i][j] = 1 + matrix[i - 1][j];
					} else {
						dp[i][j] = 1 + Integer.min(matrix[i - 1][j], matrix[i][j - 1]);
					}
				}
			}
		}

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] != 0) {
					if (i == m - 1 && j == n - 1)
						matrix[i][j] = dp[i][j];
					else if (i == m - 1)
						matrix[i][j] = Integer.min(dp[i][j], 1 + matrix[i][j + 1]);
					else if (j == n - 1)
						matrix[i][j] = Integer.min(dp[i][j], 1 + matrix[i + 1][j]);
					else
						matrix[i][j] = Integer.min(dp[i][j], 1 + Integer.min(matrix[i][j + 1], matrix[i + 1][j]));
				}
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		
		mat = updateMatrix(mat);
		
		System.out.println(Arrays.deepToString(mat));

	}

}
