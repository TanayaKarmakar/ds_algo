package com.app.practice;

public class IsSubsequenceLeetcode392 {
	private static boolean isSubsequence(String s, String t) {
		int n = s.length();
		int m = t.length();
		
		boolean[][] dp = new boolean[m + 1][n + 1];
		
		for(int i = 0; i <= m; i++) {
			dp[i][0] = true;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j];
				if(s.charAt(j - 1) == t.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} 
			}
		}
		
		return dp[m][n];
	}

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		
		System.out.println(isSubsequence(s, t));
		
		s = "axc";
		t = "ahbgdc";
		
		System.out.println(isSubsequence(s, t));

	}

}
