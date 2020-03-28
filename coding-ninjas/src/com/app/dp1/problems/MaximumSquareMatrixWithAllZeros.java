package com.app.dp1.problems;

public class MaximumSquareMatrixWithAllZeros {
	private static int maxCount(int[][] input) {
		int m = input.length;
		int n = input[0].length;

		int[][] dp = new int[m][n];
		int res = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (input[0][i] == 0) {
				dp[0][i] = 1;
				res = Integer.max(res, dp[0][i]);
			}
		}

		for (int i = 0; i < m; i++) {
			if (input[i][0] == 0) {
				dp[i][0] = 1;
				res = Integer.max(res, dp[i][0]);
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (input[i][j] == 0) {
					int option1 = dp[i - 1][j - 1];
					int option2 = dp[i - 1][j];
					int option3 = dp[i][j - 1];
					dp[i][j] = 1 + Integer.min(option1, Integer.min(option2, option3));
					res = Integer.max(res, dp[i][j]);
				}
			}
		}

		//System.out.println(Arrays.deepToString(dp));
		return res;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 } };

		int maxVal = maxCount(mat);

		System.out.println(maxVal);

	}

}
