package com.app.questions.practice;

public class MaximalSquareLeetcode221 {
	private static int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];

		int maxWidth = -1;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == '1') {
				dp[i][0] = 1;
				maxWidth = dp[i][0];
			}		
		}

		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == '1') {
				dp[0][i] = 1;
				maxWidth = dp[0][i];
			}
				
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = 1 + Integer.min(dp[i - 1][j - 1], Integer.min(dp[i - 1][j], dp[i][j - 1]));
					maxWidth = Integer.max(maxWidth, dp[i][j]);
				}
			}
		}

		if (maxWidth == -1)
			return 0;
		return maxWidth * maxWidth;
	}

	public static void main(String[] args) {
		char[][] mat = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		int maxSquare = maximalSquare(mat);
		
		System.out.println(maxSquare);

	}

}
