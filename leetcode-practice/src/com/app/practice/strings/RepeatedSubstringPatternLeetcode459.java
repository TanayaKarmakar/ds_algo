package com.app.practice.strings;

import java.util.Scanner;

public class RepeatedSubstringPatternLeetcode459 {
	private static boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		int[] lps = new int[n];
		
		int j = 0;
		int i = 1;
		while(i < n) {
			if(s.charAt(i) == s.charAt(j)) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {	
				if(j == 0) {
					i++;
				} else {
					j = lps[j - 1];
				}
			}
		}
		
		int lpsLen = n - lps[n - 1];
		if(n % lpsLen == 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.next();
		
		boolean isRepeatedSubstring = repeatedSubstringPattern(text);
		
		System.out.println(isRepeatedSubstring);
		
		scanner.close();

	}

}
