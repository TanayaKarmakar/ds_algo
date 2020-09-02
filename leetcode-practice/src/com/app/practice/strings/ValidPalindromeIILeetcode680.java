package com.app.practice.strings;

import java.util.Scanner;

public class ValidPalindromeIILeetcode680 {
	private static boolean isPossible(String s, int indx) {
		String left = s.substring(0, indx);
		String right = s.substring(indx + 1);
		StringBuilder sb = new StringBuilder(left + right);
		return sb.reverse().toString().equals(left + right);
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
		
		if(start == end || start + 1 == end)
			return true;
		return isPossible(s, start) || isPossible(s, end);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String txt = scanner.next();
		
		System.out.println(validPalindrome(txt));
		
		scanner.close();
	}

}
