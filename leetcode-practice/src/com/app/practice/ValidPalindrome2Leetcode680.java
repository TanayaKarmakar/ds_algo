package com.app.practice;

public class ValidPalindrome2Leetcode680 {
	private static boolean isPossible(String s, int indx) {
		String left = s.substring(0, indx);
		String right = s.substring(indx + 1);
		StringBuilder sb = new StringBuilder(left + right);
		String str = sb.toString();
		String rev = sb.reverse().toString();
		return str.equals(rev);
	}
	
	private static boolean validPalindrome(String s) {
		int n = s.length();
		int start = 0;
		int end = n - 1;
		
		while(start < end) {
			if(s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				break;
			}
		}
		return isPossible(s, start) || isPossible(s, end);
	}

	public static void main(String[] args) {
		String str = "aba";
		
		System.out.println(validPalindrome(str));
		
		str = "abca";
		
		System.out.println(validPalindrome(str));

	}

}
