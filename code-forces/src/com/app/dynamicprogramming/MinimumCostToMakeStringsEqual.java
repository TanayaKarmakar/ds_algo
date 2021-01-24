package com.app.dynamicprogramming;

public class MinimumCostToMakeStringsEqual {
	private static int minCost(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = str1.length() - 1; i >= 0; i--) {
			for (int j = str2.length() - 1; j >= 0; j--) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Integer.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}

		int totalCost = (str1.length() + str2.length()) - 2 * dp[0][0];
		return totalCost;
	}

	public static void main(String[] args) {
		
	}

}
