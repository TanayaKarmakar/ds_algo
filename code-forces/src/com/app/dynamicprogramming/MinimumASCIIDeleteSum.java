package com.app.dynamicprogramming;

public class MinimumASCIIDeleteSum {
	private static int minAsciiDel(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = str1.length() - 1; i >= 0; i--) {
			dp[i][str2.length()] = str1.charAt(i) + dp[i + 1][str2.length()];
		}

		for (int i = str2.length() - 1; i >= 0; i--) {
			dp[str1.length()][i] = str2.charAt(i) + dp[str1.length()][i + 1];
		}

		for (int i = str1.length() - 1; i >= 0; i--) {
			for (int j = str2.length() - 1; j >= 0; j--) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1];
				} else {
					int option1 = str1.charAt(i) + dp[i + 1][j];
					int option2 = str2.charAt(j) + dp[i][j + 1];
					dp[i][j] = Integer.min(option1, option2);
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		String str1 = "sea";
		String str2 = "eat";
		
		int ans = minAsciiDel(str1, str2);
		
		System.out.println(ans);

	}

}
