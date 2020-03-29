package com.app.questions;

public class BasicRegexParserLeetcode10 {
	private static boolean isMatch(String str, String pattern) {
		int m = str.length();
		int n = pattern.length();

		boolean[][] dp = new boolean[m + 1][n + 1];

		dp[0][0] = true;

		for (int i = 1; i <= n; i++) {
			if (pattern.charAt(i - 1) == '*') {
				dp[0][i] = dp[0][i - 2];
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')
					dp[i][j] = dp[i - 1][j - 1];
				else if(pattern.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2];
					if(str.charAt(i - 1) == pattern.charAt(j - 2) 
							|| pattern.charAt(j - 2) == '.') {
						dp[i][j] = dp[i][j] | dp[i - 1][j];
					}
				} else {
					dp[i][j] = false;
				}
			}
		}
		
		return dp[m][n];
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","a*"));
		System.out.println(isMatch("aaa", "ab*a*c*a"));

	}

}
