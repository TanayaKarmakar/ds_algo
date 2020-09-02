package com.app.practice.strings;

import java.util.Scanner;

public class FindUniqueCharactersInAStringLeetcode387 {
	private static int firstUniqueChar(String txt) {
		int[] chars = new int[26];
		
		int n = txt.length();
		for(int i = 0; i < n; i++) {
			int indx = txt.charAt(i) - 'a';
			chars[indx]++;
		}
		
		for(int i = 0; i < n; i++) {
			int indx = txt.charAt(i) - 'a';
			if(chars[indx] == 1)
				return i;
		}
		
		return -1;
 	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String txt = scanner.next();
		
		int ans = firstUniqueChar(txt);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
