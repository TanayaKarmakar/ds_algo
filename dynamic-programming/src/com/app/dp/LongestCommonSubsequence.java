package com.app.dp;

public class LongestCommonSubsequence {
	private static void findLCS(String x, String y) {
		int m = x.length();
		int n = y.length();
		int[][] lcs = new int[m][n];

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (x.charAt(i) == y.charAt(j)) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = Integer.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		System.out.println(lcs[m - 1][n - 1]);
		StringBuilder sb = new StringBuilder();
		int i = m - 1;
		int j = n - 1;
		while (i > 0 && j > 0) {
			if(x.charAt(i) == y.charAt(j)) {
				sb.append(x.charAt(i));
				i--;
				j--;
			} else if(lcs[i - 1][j] > lcs[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		System.out.println(sb.reverse().toString());
	}

	public static void main(String[] args) {
		String xStr = "strongest";
		String yStr = "longivity";
		findLCS(xStr, yStr);
	}

}
