package com.app.questions;

public class UniquePathsDP {
	private static boolean isSafe(int i, int j, int m, int n) {
		if(i >= 0 && i <= m - 1 && j >=0 && j <= n - 1)
			return true;
		return false;
	}
	
	private static int uniquePath(int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				dp[i][j] += isSafe(i - 1, j, m, n) ? dp[i - 1][j]: 0;
				dp[i][j] += isSafe(i, j - 1, m, n) ? dp[i][j - 1]: 0;
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		System.out.println(uniquePath(3, 2));
		System.out.println(uniquePath(7, 3));
		System.out.println(uniquePath(19, 13));

	}

}
