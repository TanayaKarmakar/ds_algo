package com.app.dynamicprogramming;

public class LongestPalindromicSubstring {
	private static int longestPalindromicSubstring(String str) {
		int n = str.length();
		boolean[][] dp = new boolean[n][n];
		
		int maxLen = 1;
		for(int i = 0; i < n; i++) {
			dp[i][i] = true;
		}
		
		for(int startIndx = n - 2; startIndx >= 0; startIndx--) {
			for(int endIndx = startIndx + 1; endIndx < n; endIndx++) {
				if(str.charAt(startIndx) == str.charAt(endIndx)) {
					if(endIndx - startIndx == 1) {
						dp[startIndx][endIndx] = true;
					} else {
						dp[startIndx][endIndx] = dp[startIndx + 1][endIndx - 1];
					}
					
					if(dp[startIndx][endIndx]) {
						maxLen = Integer.max(maxLen, endIndx - startIndx + 1);
					}
				}
			}
		}
		
		return maxLen;
	}

	public static void main(String[] args) {
		String str = "abccbc";
		
		int ans = longestPalindromicSubstring(str);
		
		System.out.println(ans);

	}

}
