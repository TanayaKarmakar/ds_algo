package com.app.practice.dp;

import java.util.Scanner;

public class LongestPalindromicSubstringLeetcode5 {
	private static String longestPalindrome(String s) {
		if(s.length() <= 1)
			return s;
		int n = s.length();
		int i = 0;
		int maxLength = 1;
		int start = -1;
		while(i < n) {
			int left = i;
			int right = i;
			while(left >= 0 && right < n && 
					s.charAt(left) == s.charAt(right)) {
				if((right - left + 1) > maxLength) {
					maxLength = (right - left) + 1;
					start = i;
				}
				left--;
				right++;
			}
			
			left = i - 1;
			right = i;
			while(left >= 0 && right < n && 
					s.charAt(left) == s.charAt(right)) {
				if((right - left + 1) > maxLength) {
					maxLength = (right - left) + 1;
					start = i;
				}
				left--;
				right++;
			}
			i++;
		}
		return s.substring(start, start + maxLength);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String txt = scanner.next();
		
		String ans = longestPalindrome(txt);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
