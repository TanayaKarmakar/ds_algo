package com.app.practice.strings;

import java.util.Scanner;

public class ValidAnagramLeetcode242 {
	private static boolean isValidAnagram(String s, String t) {
		if(s.length() != t.length())
			return false;
		int[] freq = new int[26];
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			int indx = s.charAt(i) - 'a';
			freq[indx]++;
		}
		
		for(int i = 0; i < n; i++) {
			int indx = t.charAt(i) - 'a';
			freq[indx]--;
			
			if(freq[indx] < 0)
				return false;
		}
		
		for(int i = 0; i < 26; i++) {
			if(freq[i] != 0)
				return false;
		}
		return true;
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.next();
		String t = scanner.next();

		boolean ans = isValidAnagram(s, t);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
