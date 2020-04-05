package com.app.dp2.problems;

public class MinimumEditDistanceBottomUp {
	private static int minEditDistance(String s1, String s2) {
		String temp;
		if (s1.length() > s2.length()) {
			temp = s1;
			s1 = s2;
			s2 = temp;
		}
		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}

		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int option1 = 1 + dp[i - 1][j - 1];
					int option2 = 1 + dp[i - 1][j];
					int option3 = 1 + dp[i][j - 1];
					dp[i][j] = Integer.min(option1, Integer.min(option2, option3));
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "";
		
		int ans = minEditDistance(s1, s2);
		
		System.out.println(ans);
	}

}
