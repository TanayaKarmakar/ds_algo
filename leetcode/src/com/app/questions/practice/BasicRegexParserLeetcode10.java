package com.app.questions.practice;

public class BasicRegexParserLeetcode10 {
	private static boolean isMatch(String str, String patt) {
		int m = str.length();
		int n = patt.length();

		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;

		for (int i = 1; i <= n; i++) {
			if (patt.charAt(i - 1) == '*') {
				dp[0][i] = dp[0][i - 2];
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str.charAt(i - 1) == patt.charAt(j - 1) || patt.charAt(j - 1) == '.')
					dp[i][j] = dp[i - 1][j - 1];
				else {
					if (patt.charAt(j - 1) == '*') {
						dp[i][j] = dp[i][j - 2];
						if(str.charAt(i - 1) == patt.charAt(j - 2) || patt.charAt(j - 2) == '.') {
							dp[i][j] = dp[i][j] | dp[i - 1][j];
						}
					} else {
						dp[i][j] = false;
					}
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String str = "aa";
		String patt = "a*";
		
		System.out.println(isMatch(str, patt));

	}

}
