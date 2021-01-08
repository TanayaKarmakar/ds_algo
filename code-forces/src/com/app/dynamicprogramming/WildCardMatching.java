package com.app.dynamicprogramming;

public class WildCardMatching {
	private static boolean isMatch(String str, String pattern) {
		boolean[][] dp = new boolean[pattern.length() + 1][str.length() + 1];
		
		dp[pattern.length()][str.length()] = true;
		
		for(int i = pattern.length() - 1; i >= 0; i--) {
			for(int j = str.length() - 1; j >= 0; j--) {
				if(str.charAt(j) == pattern.charAt(i) || pattern.charAt(i) == '?') {
					dp[i][j] = dp[i + 1][j + 1];
				}
				if(pattern.charAt(i) == '*') {
					if(j == str.length()) {
						dp[i][j] = dp[i + 1][j];
					} else
						dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
				}
			}
		}
		
		return dp[0][0];
	}

	public static void main(String[] args) {
		String str = "baaabab";
		String pattern = "ba*?";
		
		boolean ans = isMatch(str, pattern);
		
		System.out.println(ans);

	}

}
