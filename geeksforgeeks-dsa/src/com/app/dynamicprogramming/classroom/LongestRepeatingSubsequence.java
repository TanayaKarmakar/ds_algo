package com.app.dynamicprogramming.classroom;

public class LongestRepeatingSubsequence {
	private static int findLongestValue(String str1) {
		String str2 = str1;
		int n = str1.length();
		int[][] lcs = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1) && i != j) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = Integer.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		
		return lcs[n][n];
	}

	public static void main(String[] args) {
		String txt1 = "AABB";
		
		System.out.println(findLongestValue(txt1));

	}

}
