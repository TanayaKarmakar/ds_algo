package com.app.questions.practice;

public class LongestCommonPrefixLeetcode14 {
	private static String longestCommonPrefix(String[] strs) {
		int maxLen = Integer.MIN_VALUE;
		int minLen = Integer.MAX_VALUE;

		for (String str : strs) {
			maxLen = Integer.max(maxLen, str.length());
			minLen = Integer.min(minLen, str.length());
		}

		char[][] mat = new char[strs.length][maxLen];

		for (int i = 0; i < strs.length; i++) {
			mat[i] = strs[i].toCharArray();
		}

		int len = 0;
		boolean isEqual = true;
		for (int j = 0; j < minLen; j++) {
			for (int i = 1; i < strs.length; i++) {
				if (mat[i - 1][j] != mat[i][j]) {
					isEqual = false;
					break;
				}
			}
			if (!isEqual) {
				break;
			}
			len++;
		}
		return strs[0].substring(0, len);
	}

	public static void main(String[] args) {
//		String[] strs = { "flower", "flow", "flight" };
//		
//		System.out.println(longestCommonPrefix(strs));
		
		String[] strs = new String[] {"aa", "a"};
		
		System.out.println(longestCommonPrefix(strs));

	}

}
