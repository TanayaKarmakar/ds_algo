package com.app.dynamicprogramming;

public class LongestPalindromicSubsequence {
	private static int longestPalindromicSubsequence(String str) {
		int n = str.length();

		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		int max = 1;
		for (int startIndx = n - 2; startIndx >= 0; startIndx--) {
			for(int endIndx = startIndx + 1; endIndx < n; endIndx++) {
				if(str.charAt(startIndx) == str.charAt(endIndx)) {
					dp[startIndx][endIndx] = 2 + dp[startIndx + 1][endIndx - 1];
				} else {
					dp[startIndx][endIndx] = Integer.max(dp[startIndx + 1][endIndx],
							dp[startIndx][endIndx - 1]);
				}
				max = Integer.max(max, dp[startIndx][endIndx]);
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		String str = "abkccbc";
		
		int maxLen = longestPalindromicSubsequence(str);
		
		System.out.println(maxLen);

	}

}
