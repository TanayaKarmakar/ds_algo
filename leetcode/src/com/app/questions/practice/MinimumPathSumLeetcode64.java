package com.app.questions.practice;

public class MinimumPathSumLeetcode64 {
	
	private static int minPathSum(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		
		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = mat[m - 1][n - 1];
		for(int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = dp[i + 1][n - 1] + mat[i][n - 1];
		}
		
		for(int i = n - 2; i >= 0; i--) {
			dp[m - 1][i] = dp[m - 1][i + 1] + mat[m - 1][i];
		}
			
		for(int i = m - 2; i >= 0; i--) {
			for(int j = n - 2; j >= 0; j--) {
				dp[i][j] = mat[i][j] + Integer.min(dp[i + 1][j], dp[i][j + 1]);
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 3, 1, }, { 1, 5, 1 }, { 4, 2, 1 } };
		int minPathSum = minPathSum(mat);
		
		System.out.println(minPathSum);

	}

}
