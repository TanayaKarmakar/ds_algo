package com.app.dynamicprogramming;

public class MinimumPalindromicCut {
	private static int minCuts(String str) {
		int n = str.length();
		boolean[][] dp = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			dp[i][i] = true;
		}
		
		for(int startIndx = n - 2; startIndx >= 0; startIndx--) {
			for(int endIndx = startIndx + 1; endIndx < n; endIndx++) {
				if(str.charAt(startIndx) == str.charAt(endIndx)) {
					if(endIndx - startIndx == 1)
						dp[startIndx][endIndx] = true;
					else
						dp[startIndx][endIndx] = dp[startIndx + 1][endIndx - 1];
				}
			}
		}
		
		int[] storage = new int[str.length()];
		
		for(int j = 1; j < str.length(); j++) {
			if(dp[0][j]) {
				storage[j] = 0;
			} else {
				int min = Integer.MAX_VALUE;
				for(int i = j; i >= 1; i--) {
					if(dp[i][j]) {
						min = Integer.min(min, storage[i - 1]);
					}
				}
				storage[j] = min + 1;
			}
		}
		
		return storage[str.length() - 1];
	}

	public static void main(String[] args) {
		String str = "abccbc";
		
		int ans = minCuts(str);
		
		System.out.println(ans);

	}

}
