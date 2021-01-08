package com.app.dynamicprogramming;

public class LongestCommonSubsequence {
	private static int lcs(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		
		int[][] dp = new int[m + 1][n + 1];
		for(int i = m - 1; i >= 0; i--) {
			for(int j = n - 1; j >= 0; j--) {
				if(str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Integer.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "aebd";
		
		int len = lcs(str1, str2);
		
		System.out.println(len);

	}

}
