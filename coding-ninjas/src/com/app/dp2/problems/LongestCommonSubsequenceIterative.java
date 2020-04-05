package com.app.dp2.problems;

public class LongestCommonSubsequenceIterative {
	private static int lcs(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		
		int[][] dp = new int[m + 1][n + 1];
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					int option1 = dp[i - 1][j];
					int option2 = dp[i][j - 1];
					dp[i][j] = Integer.max(option1, option2);
				}
			}
		}
		
		return dp[m][n];
	}

	public static void main(String[] args) {
		String str1 = "abcdefg";
		String str2 = "agdeij";
		
		int lcs = lcs(str1, str2);
		
		System.out.println(lcs);

	}

}
