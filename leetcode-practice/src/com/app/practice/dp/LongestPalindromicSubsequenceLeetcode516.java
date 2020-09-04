package com.app.practice.dp;

import java.util.Scanner;

public class LongestPalindromicSubsequenceLeetcode516 {
	private static int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		for (int startIndx = n - 2; startIndx >= 0; startIndx--) {
			for (int endIndx = startIndx + 1; endIndx < n; endIndx++) {
				if (s.charAt(startIndx) == s.charAt(endIndx)) {
					dp[startIndx][endIndx] = 2 + dp[startIndx + 1][endIndx - 1];
				} else {
					int option1 = dp[startIndx + 1][endIndx];
					int option2 = dp[startIndx][endIndx - 1];
					dp[startIndx][endIndx] = Integer.max(option1, option2);
				}
			}
		}

		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.next();

		int ans = longestPalindromeSubseq(txt);

		System.out.println(ans);

		scanner.close();
	}

}
