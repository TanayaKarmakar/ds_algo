package com.app.questions.practice;

public class UniquePathsLeetcode62 {
	private static boolean isSafe(int i, int j, int m, int n) {
		if(i >= 0 && i <= m - 1 && j >= 0 && j <= n - 1)
			return true;
		return false;
	}
	
	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				dp[i][j] += isSafe(i - 1, j, m, n) ? dp[i - 1][j] : 0;
				dp[i][j] += isSafe(i, j - 1, m, n) ? dp[i][j - 1] : 0;
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		
		int totalWays = uniquePaths(m, n);
		System.out.println(totalWays);

	}

}
