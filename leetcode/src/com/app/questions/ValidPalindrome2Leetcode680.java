package com.app.questions;

public class ValidPalindrome2Leetcode680 {
	private static boolean isPossible(String s, int indx) {
		String left = s.substring(0, indx);
		String right = s.substring(indx + 1);
		StringBuilder sb = new StringBuilder(left + right);
		return sb.reverse().toString().equals(left + right);
	}
	
	private static boolean validPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while(start < end) {
			if(s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				break;
			}
		}
		if(start == end || start + 1 == end)
			return true;
		return isPossible(s, start) || isPossible(s, end);
	}

	public static void main(String[] args) {
		System.out.println(validPalindrome("aba"));
		System.out.println(validPalindrome("abca"));
		System.out.println(validPalindrome("abc"));

	}

}
