package com.app.questions.dp;

public class LongestIncreasingPathInMatrixLeetcode329 {
	private static int dfs(int[][] matrix, int[][] dp, int i, int j, int prev) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || prev >= matrix[i][j])
			return 0;
		if (dp[i][j] != 0)
			return dp[i][j];
		int path1 = dfs(matrix, dp, i + 1, j, matrix[i][j]);
		int path2 = dfs(matrix, dp, i - 1, j, matrix[i][j]);
		int path3 = dfs(matrix, dp, i, j + 1, matrix[i][j]);
		int path4 = dfs(matrix, dp, i, j - 1, matrix[i][j]);

		int max1 = Integer.max(path1, path2);
		int max2 = Integer.max(path3, path4);
		int max = 1 + Integer.max(max1, max2);
		dp[i][j] = max;

		return max;
	}

	private static int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];

		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == 0) {
					dfs(matrix, dp, i, j, Integer.MIN_VALUE);
					max = Integer.max(max, dp[i][j]);
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };

		System.out.println(longestIncreasingPath(matrix));

		matrix = new int[][] { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };

		System.out.println(longestIncreasingPath(matrix));

	}

}
