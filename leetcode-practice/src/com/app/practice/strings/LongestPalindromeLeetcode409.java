package com.app.practice.strings;

public class LongestPalindromeLeetcode409 {
	private static int longestPalindrome(String s) {
		if (s.length() <= 1)
			return s.length();
		int[] charCount = new int[256];
		int n = s.length();

		for (int i = 0; i < n; i++) {
			charCount[s.charAt(i)]++;
		}

		boolean oddCount = false;
		int maxLen = 0;
		for (int i = 0; i < 256; i++) {
			if (charCount[i] != 0) {
				if (charCount[i] % 2 != 0) {
					oddCount = true;
					maxLen += (charCount[i] - 1);
				} else {
					maxLen += charCount[i];
				}
				charCount[i] = 0;
			}
		}

		return oddCount ? maxLen + 1 : maxLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
