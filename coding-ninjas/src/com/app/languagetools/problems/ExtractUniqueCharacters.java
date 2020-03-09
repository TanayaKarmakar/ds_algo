package com.app.languagetools.problems;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ExtractUniqueCharacters {
	private static String getModifiedString(String input) {
		Set<Character> set = new LinkedHashSet<>();
		for(int i = 0;i<input.length();i++) {
			set.add(input.charAt(i));
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(Character str: set) {
			sb.append(str);
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		String str = getModifiedString(input);
		
		System.out.println(str);
		scanner.close();
	}

}
