package com.app.practice.strings;

public class ValidPalindromeIILeetCode680 {
	private static boolean isPossible(String s, int indx) {
		String left = s.substring(0, indx);
		String right = s.substring(indx + 1);
		StringBuilder sb = new StringBuilder(left + right);
		return sb.reverse().toString().equals(left + right);
	}

	private static boolean validPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				break;
			}
		}

		return isPossible(s, start) || isPossible(s, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
