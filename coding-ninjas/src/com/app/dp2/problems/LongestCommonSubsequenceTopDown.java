package com.app.dp2.problems;

import java.util.Arrays;

public class LongestCommonSubsequenceTopDown {
	private static int lcsHelper(int[][] dp, String s1, String s2, int indx1, 
			int indx2, int m, int n) {
		if(indx1 == m || indx2 == n)
			return 0;
		if(dp[indx1][indx2] == -1) {
			if(s1.charAt(indx1) == s2.charAt(indx2)) {
				dp[indx1][indx2] = 1 + lcsHelper(dp, s1, s2, indx1 + 1,
						indx2 + 1, m, n);
			} else {
				int option1 = lcsHelper(dp, s1, s2, indx1 + 1, indx2, m, n);
				int option2 = lcsHelper(dp, s1, s2, indx1, indx2 + 1, m, n);
				dp[indx1][indx2] = Integer.max(option1, option2);
			}
		}
		return dp[indx1][indx2];
	}
	
	private static int lcs(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 0; i <= m; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		return lcsHelper(dp, s1, s2, 0, 0, m, n);
	}

	public static void main(String[] args) {
		String str1 = "abcdefg";
		String str2 = "agdeij";
		
		int lcs = lcs(str1, str2);
		
		System.out.println(lcs);

	}

}
