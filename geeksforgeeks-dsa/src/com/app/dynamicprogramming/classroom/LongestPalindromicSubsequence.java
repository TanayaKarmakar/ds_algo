package com.app.dynamicprogramming.classroom;

public class LongestPalindromicSubsequence {
	private static int longestPalindromicSubsequence(String txt1) {
		StringBuilder sb = new StringBuilder(txt1);
		String txt2 = sb.reverse().toString();

		int n = txt1.length();
		int[][] lcs = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(txt1.charAt(i - 1) == txt2.charAt(j - 1)) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = Integer.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		return lcs[n][n];
	}

	public static void main(String[] args) {
		String txt1 = "geeksforgeeks";
		
		System.out.println(longestPalindromicSubsequence(txt1));

	}

}
