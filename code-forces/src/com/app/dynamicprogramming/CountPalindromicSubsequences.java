package com.app.dynamicprogramming;

public class CountPalindromicSubsequences {
	private static int countPalindromicSubsequences(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		
		for(int startIndx = n - 2; startIndx >= 0; startIndx--) {
			for(int endIndx = startIndx + 1; endIndx < n; endIndx++) {
				if(endIndx - startIndx == 1) {
					if(str.charAt(startIndx) == str.charAt(endIndx)) {
						dp[startIndx][endIndx] = 3;
					} else {
						dp[startIndx][endIndx] = 2;
					}
				} else {
					if(str.charAt(startIndx) == str.charAt(endIndx) ) {
						dp[startIndx][endIndx] = dp[startIndx][endIndx - 1]
								+ dp[startIndx + 1][endIndx] + 1;
					} else {
						dp[startIndx][endIndx] = dp[startIndx][endIndx - 1]
								+ dp[startIndx + 1][endIndx] - dp[startIndx + 1][endIndx - 1];
					}
				}
			}
		}
		
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		String str = "abccbc";
		
		int ans = countPalindromicSubsequences(str);
		
		System.out.println(ans);

	}

}
