package com.app.problems.gfg.dp.sample;

import java.util.Scanner;

public class LongestRepeatingSubsequence {
	private static int lrs(String str) {
		int n = str.length();
		int[][] dp = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i != j && str.charAt(i - 1) == str.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.next();

		int ans = lrs(text);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
