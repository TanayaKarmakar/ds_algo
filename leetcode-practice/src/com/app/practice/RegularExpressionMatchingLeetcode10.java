package com.app.practice;

public class RegularExpressionMatchingLeetcode10 {
	private static boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		
		boolean[][] dp = new boolean[m + 1][n + 1];
		
		for(int i = 0; i <= m; i++) {
			dp[i][0] = true;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s.charAt(i - 1) == p.charAt(j - 1)
						|| p.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if(p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2];
					if(s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
						dp[i][j] = dp[i][j] | dp[i - 1][j];
					}
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String s = "aa";
		String t = "a*";
		
		System.out.println(isMatch(s, t));

		s = "aab";
		t = "c*a*b";
		
		System.out.println(isMatch(s, t));
		
		s = "mississippi";
		t = "mis*is*p*.";
		
		System.out.println(isMatch(s, t));
	}

}
