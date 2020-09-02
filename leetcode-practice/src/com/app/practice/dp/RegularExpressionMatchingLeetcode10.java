package com.app.practice.dp;

public class RegularExpressionMatchingLeetcode10 {
	private static boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		
		boolean[][] dp = new boolean[m + 1][n + 1];
		for(int i = 0; i <= m; i++) {
			dp[i][0] = true;
		} 
		
		for(int j = 1; j <= n; j++) {
			if(p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 2];
			}
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if(p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1];
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
		String p = "a";
		
		boolean match = isMatch(s, p);
		
		System.out.println(match);
		
		s = "aa";
		p = "a*";
		
		match = isMatch(s, p);
		
		System.out.println(match);
		
		s = "ab";
		p = ".*";
		
		match = isMatch(s, p);
		
		System.out.println(match);
		
		s = "aab";
		p = "c*a*b";
		
		match = isMatch(s, p);
		
		System.out.println(match);
		
		s = "mississippi";
		p = "mis*is*p*.";
		
		match = isMatch(s, p);
		
		System.out.println(match);

	}

}
