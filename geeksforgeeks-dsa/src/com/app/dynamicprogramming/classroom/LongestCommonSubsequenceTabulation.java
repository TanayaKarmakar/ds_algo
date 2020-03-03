package com.app.dynamicprogramming.classroom;

public class LongestCommonSubsequenceTabulation {
	private static int lcs(String str1, String str2, int m, int n) {
		int[][] tab = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1))
					tab[i][j] = 1 + tab[i - 1][j - 1];
				else {
					tab[i][j] = Integer.max(tab[i - 1][j], tab[i][j - 1]);
				}
			}
		}
		
		return tab[m][n];
	}

	public static void main(String[] args) {
		String str1 = "AXYZ";
		String str2 = "BAZ";
		
		System.out.println("Length of LCS - " + lcs(str1, str2, str1.length(), str2.length()));
	}

}
