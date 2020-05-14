package com.app.problems.codeforces;

import java.util.Scanner;

public class AWayTooLongWords {
	private static String compress(String str) {
		if(str.length() <= 10)
			return str;
		int n = str.length();
		return "" + str.charAt(0) + (n - 2) + str.charAt(n - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while(n > 0) {
			String str = scanner.next();
			System.out.println(compress(str));
			n--;
		}
		scanner.close();

	}

}
