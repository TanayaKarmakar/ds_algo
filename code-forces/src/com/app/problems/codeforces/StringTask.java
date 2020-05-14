package com.app.problems.codeforces;

import java.util.Scanner;

public class StringTask {
	private static boolean isVowel(char ch) {
		return (ch == 'a' || ch == 'e' || ch == 'i' 
				|| ch == 'o' || ch == 'u' || ch == 'y');
	}
	
	private static String formatString(String str) {
		str = str.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			if(!isVowel(str.charAt(i))) {
				sb.append("." + str.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.next();
		
		System.out.println(formatString(str));
		
		scanner.close();

	}

}
