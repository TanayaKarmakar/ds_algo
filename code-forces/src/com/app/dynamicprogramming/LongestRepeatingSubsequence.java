package com.app.dynamicprogramming;

public class LongestRepeatingSubsequence {
	private static int lrs(String str) {
		int[][] dp = new int[str.length() + 1][str.length() + 1];

		for (int i = str.length() - 1; i >= 0; i--) {
			for (int j = str.length() - 1; j >= 0; j--) {
				if (str.charAt(i) == str.charAt(j) && i != j) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Integer.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		String str = "abacbc";
		int len = lrs(str);

		System.out.println(len);

	}

}
