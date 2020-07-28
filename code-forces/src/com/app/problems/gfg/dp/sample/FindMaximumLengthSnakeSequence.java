package com.app.problems.gfg.dp.sample;

public class FindMaximumLengthSnakeSequence {
	private static int findMaxLen(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		int[][] dp = new int[m][n];
		for (int i = 1; i < n; i++) {
			if (mat[0][i - 1] + 1 == mat[0][i] || mat[0][i - 1] - 1 == mat[0][i]) {
				dp[0][i] = 1 + dp[0][i - 1];
			}
		}

		for (int i = 1; i < m; i++) {
			if (mat[i - 1][0] + 1 == mat[i][0] || mat[i - 1][0] - 1 == mat[i][0]) {
				dp[i][0] = 1 + dp[i - 1][0];
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				boolean isTop = ((mat[i - 1][j] + 1 == mat[i][j]) || (mat[i - 1][j] - 1 == mat[i][j]));

				boolean isLeft = ((mat[i][j - 1] + 1 == mat[i][j]) || (mat[i][j - 1] - 1 == mat[i][j]));

				if (isTop && isLeft) {
					dp[i][j] = 1 + Integer.max(dp[i - 1][j], dp[i][j - 1]);
				} else if (isTop) {
					dp[i][j] = 1 + dp[i - 1][j];
				} else if (isLeft) {
					dp[i][j] = 1 + dp[i][j - 1];
				}
			}
		}

		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] mat = { { 9, 6, 5, 2 }, { 8, 7, 6, 5 }, { 7, 3, 1, 6 }, { 1, 1, 1, 7 } };
		int len = findMaxLen(mat);
		
		System.out.println("Length - " + len);
	}

}
