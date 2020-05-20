package com.app.stringalgo.problems;

public class NaivePatternSearch {
	private static boolean hasPattern(String str, String pattern) {
		int sLen = str.length();
		int pLen = pattern.length();

		for (int i = 0; i <= (sLen - pLen); i++) {
			boolean hasPattern = true;
			for (int j = 0; j < pLen; j++) {
				if (str.charAt(i + j) != pattern.charAt(j)) {
					hasPattern = false;
					break;
				}
			}
			if (hasPattern)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		String str = "abcadbcd";
		String pattern = "bcd";

		boolean hasPattern = hasPattern(str, pattern);

		System.out.println(hasPattern);
		
		str = "abcadbcb";
		pattern = "bcd";
		
		hasPattern = hasPattern(str, pattern);

		System.out.println(hasPattern);

	}

}
