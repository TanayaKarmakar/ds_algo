package com.app.problems.codeforces;

import java.util.Scanner;

public class WordCapitalization {
	private static String capitalize(String str) {
		if (str.charAt(0) >= 65 && str.charAt(0) <= 91)
			return str;
		char ch = (char)(str.charAt(0) - 32);
		return String.valueOf(ch) + str.substring(1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();

		System.out.println(capitalize(str));
		scanner.close();

	}

}
