package com.app.augustchallenge;

import java.util.Scanner;

public class ValidPalindrome {
	private static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		s = s.replaceAll("[^0-9a-z]", "");
		
		int start = 0;
		int end = s.length() - 1;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.next();
		boolean ans = isPalindrome(text);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
