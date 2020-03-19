package com.app.dynamicprogramming.classroom;

public class MatrixChainMultiplication {
	private static int minNumberOfMultiplication(int[] p) {
		int n = p.length;
		int[][] mat = new int[n][n];
		int[][] s = new int[n][n];

		for (int d = 1; d < n - 1; d++) {
			for (int i = 1; i < n - d; i++) {
				int res = Integer.MAX_VALUE;
				int j = i + d;

				for (int k = i; k <= j - 1; k++) {
					int curr = mat[i][k] + mat[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (res > curr) {
						res = curr;
						s[i][j] = k;
					}
					mat[i][j] = res;
				}
			}
		}

		return mat[1][n - 1];
	}

	public static void main(String[] args) {
		int[] p = { 5, 4, 6, 2, 7 };
		
		System.out.println(minNumberOfMultiplication(p));
	}

}
