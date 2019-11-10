package com.app.dp;

public class LongestCommonSubsequenceAlternate {
	private static void lcsAlternate(String xStr, String yStr) {
		int m = xStr.length();
		int n = yStr.length();

		int[][] lcs = new int[m + 1][n + 1];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if(xStr.charAt(i) == yStr.charAt(j)) {
					lcs[i][j] = 1 + lcs[i + 1][j + 1];
				} else {
					lcs[i][j] = Integer.max(lcs[i + 1][j], lcs[i][j + 1]);
				}
			}
		}
		
		System.out.println(lcs[0][0]);
		
		int i = 0;
		int j = 0;
		StringBuilder sb = new StringBuilder();
		while(i < m && j < n) {
			if(xStr.charAt(i) == yStr.charAt(j)) {
				sb.append(xStr.charAt(i));
				i++;
				j++;
			} else if((i + 1) < m && (j + 1) < n && lcs[i + 1][j] > lcs[i][j + 1]) {
				i++;
			} else {
				j++;
			}
		}
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		String xStr = "strongest";
		String yStr = "longivity";
		lcsAlternate(xStr, yStr);
	}

}
