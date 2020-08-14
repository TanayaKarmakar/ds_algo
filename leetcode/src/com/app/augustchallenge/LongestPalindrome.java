package com.app.augustchallenge;

import java.util.Scanner;


public class LongestPalindrome {
	private static int longestPalindrome(String s) {
		if(s.length() <= 1)
			return s.length();
		int[] chars = new int[256];
		
		int n = s.length();
		for(int i = 0; i < n; i++) {
			chars[s.charAt(i)]++;
		}
		
		boolean oddCount = false;
		int maxLen = 0;
		for(int i = 0; i < n; i++) {
			if(chars[s.charAt(i)] != 0) {
				if(chars[s.charAt(i)] % 2 != 0) {
					maxLen += (chars[s.charAt(i)] - 1);
					oddCount = true;
				} else {
					maxLen += chars[s.charAt(i)];
				}
				chars[s.charAt(i)] = 0;
			}
			
		}
		
		return oddCount ? (maxLen + 1): maxLen;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.next();
		
		int maxLen = longestPalindrome(txt);
		
		System.out.println(maxLen);
		
		scanner.close();

	}

}
