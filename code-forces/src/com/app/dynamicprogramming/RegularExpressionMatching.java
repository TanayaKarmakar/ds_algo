package com.app.dynamicprogramming;

import java.util.Arrays;

public class RegularExpressionMatching {
	private static boolean isMatch(String str, String pattern) {
		int m = pattern.length();
		int n = str.length();

		boolean[][] dp = new boolean[m + 1][n + 1];

		dp[0][0] = true;
		
		for(int i = 1; i <= m; i++) {
			if(pattern.charAt(i - 1) == '*')
				dp[i][0] = dp[i - 2][0];
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(str.charAt(j - 1) == pattern.charAt(i - 1) || pattern.charAt(i - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if(pattern.charAt(i - 1) == '*') {
					dp[i][j] = dp[i - 2][j];
					if(pattern.charAt(i - 2) == str.charAt(j - 1) || pattern.charAt(i - 2) == '.') 
						dp[i][j] = dp[i][j] || dp[i][j - 1];
				}
			}
		}
		
	 	
		return dp[m][n];
	}

	public static void main(String[] args) {
		String str = "mississippi";
		String pattern = "mis*i.*p*i";
		
		boolean isMatch = isMatch(str, pattern);
		
		System.out.println(isMatch);

	}

}
