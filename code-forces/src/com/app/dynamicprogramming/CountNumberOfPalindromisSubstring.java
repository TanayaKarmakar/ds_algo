package com.app.dynamicprogramming;

//this is a DP approach
public class CountNumberOfPalindromisSubstring {
	private static int countPalindromicSubstring(String str) {
		int n = str.length();
		boolean[][] dp = new boolean[n][n];
		
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			dp[i][i] = true;
			count++;
		}
		
		for(int startIndx = n - 2; startIndx >= 0; startIndx--) {
			for(int endIndx = startIndx + 1; endIndx < n; endIndx++) {
				if(str.charAt(startIndx) == str.charAt(endIndx)) {
					if(endIndx - startIndx == 1) {
						dp[startIndx][endIndx] = true;
					} else {
						dp[startIndx][endIndx] = dp[startIndx + 1][endIndx - 1];
					}
					
					if(dp[startIndx][endIndx])
						count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String str = "abccbc";
		int ans = countPalindromicSubstring(str);
		
		System.out.println(ans);
	}

}
