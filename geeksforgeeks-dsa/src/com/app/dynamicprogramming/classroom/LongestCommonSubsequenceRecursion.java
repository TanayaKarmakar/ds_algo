package com.app.dynamicprogramming.classroom;

public class LongestCommonSubsequenceRecursion {
	private static int lcs(String s1, String s2, int len1, int len2) {
		if(len1 == 0 || len2 == 0)
			return 0;
		if(s1.charAt(len1 - 1) == s2.charAt(len2 - 1))
			return 1 + lcs(s1, s2, len1 - 1, len2 - 1);
		return Integer.max(lcs(s1, s2, len1 - 1, len2), lcs(s1, s2, len1, len2 - 1));
	}

	public static void main(String[] args) {
		String str1 = "AXYZ";
		String str2 = "BAZ";
		
		System.out.println("Length of LCS - " 
		+ lcs(str1, str2, str1.length(), str2.length()));

	}

}
