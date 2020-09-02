package com.app.practice;

public class RegularExpressionMatchLeetcode10 {
	private static boolean isMatch(String str, String pattern) {
		int m = str.length();
		int n = pattern.length();
		
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		
		for(int i = 1; i <= n; i++) {
			if(pattern.charAt(i - 1) == '*')
				dp[0][i] = dp[0][i - 2];
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(str.charAt(i - 1) == pattern.charAt(j - 1) ||
						pattern.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if(pattern.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2];
					if(str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.') {
						dp[i][j] |= dp[i - 1][j];
					}
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String str = "aa";
		String pattern = "a";
		
		boolean isMatch = isMatch(str, pattern);
		
		System.out.println(isMatch);
		
		str = "aa";
		pattern = "a*";
		
		isMatch = isMatch(str, pattern);
		
		System.out.println(isMatch);
		
		str = "ab";
		pattern = ".*";
		
		isMatch = isMatch(str, pattern);
		
		System.out.println(isMatch);
		
		str = "aab";
		pattern = "c*a*b";
		
		isMatch = isMatch(str, pattern);
		
		System.out.println(isMatch);
		
		str = "mississippi";
		pattern = "mis*is*p*.";
		
		isMatch = isMatch(str, pattern);
		
		System.out.println(isMatch);

	}

}
