package com.app.dynamicprogramming.classroom;

import java.util.Arrays;

public class LongestCommonSubsequenceMemoization {
	private static int[][] memo;

	public static void initMemoTable(int m, int n) {
		memo = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			Arrays.fill(memo[i], -1);
		}
	}

	private static int lcs(String s1, String s2, int m, int n) {
		if (memo[m][n] != -1)
			return memo[m][n];
		if (m == 0 || n == 0) {
			memo[m][n] = 0;
		} else {
			if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
				memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1);
			} else {
				memo[m][n] = Integer.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
			}
		}
		return memo[m][n];
	}

	public static void main(String[] args) {
		String str1 = "AXYZ";
		String str2 = "BAZ";

		initMemoTable(str1.length(), str2.length());

		System.out.println("Length of LCS - " + lcs(str1, str2, str1.length(), str2.length()));
	}

}
