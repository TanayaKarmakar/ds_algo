package com.app.dynamicprogramming;

public class LongestCommonSubstring {
	private static int lcs(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];

		int maxLen = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
				maxLen = Integer.max(maxLen, dp[i][j]);
			}
		}

		return maxLen;
	}

	public static void main(String[] args) {
		String str1 = "pqabcxy";
		String str2 = "xyzabcp";

		int maxLen = lcs(str1, str2);
		
		System.out.println(maxLen);
	}

}
