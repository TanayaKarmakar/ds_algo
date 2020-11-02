package com.app.practice.array;

import java.util.Scanner;

public class GoatLatinLeetcode824 {
	private static boolean isVowel(String s) {
		return s.charAt(0) == 'a' || s.charAt(0) == 'A'
				|| s.charAt(0) == 'e' || s.charAt(0) == 'E'
				|| s.charAt(0) == 'i' || s.charAt(0) == 'I'
				|| s.charAt(0) == 'o' || s.charAt(0) == 'O'
				|| s.charAt(0) == 'u' || s.charAt(0) == 'U';
	}
	
	private static String toGoatLatin(String S) {
		if(S.length() == 0)
			return "";
		String[] arr = S.split("\\s+");

		StringBuilder sb = new StringBuilder();
		StringBuilder endPart = new StringBuilder("maa");
		for (String s : arr) {
			if(isVowel(s)) {
				sb.append(s + endPart.toString());
			} else {
				sb.append(s.substring(1) + s.charAt(0) + endPart.toString());
			}
			sb.append(" ");
			endPart.append("a");
		}

		return sb.toString().trim();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.nextLine();
		System.out.println(toGoatLatin(txt));

		scanner.close();

	}

}
