package com.app.questions.dp;

public class LongestCommonSubsequenceLeetcode1143 {
	private static int lcs(String txt1, String txt2) {
		int m = txt1.length();
		int n = txt2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (txt1.charAt(i - 1) == txt2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String txt1 = "abcde";
		String txt2 = "ace";

		System.out.println(lcs(txt1, txt2));

	}

}
