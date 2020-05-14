package com.app.problems.codeforces;

import java.util.Scanner;

public class PertyAndStrings {
	private static int compareStrings(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		int n = str1.length();
		for(int i = 0; i < n; i++) {
			if(str1.charAt(i) < str2.charAt(i))
				return -1;
			else if(str1.charAt(i) > str2.charAt(i))
				return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.next();
		String str2 = scanner.next();
		System.out.println(compareStrings(str1, str2));
		scanner.close();
	}

}
