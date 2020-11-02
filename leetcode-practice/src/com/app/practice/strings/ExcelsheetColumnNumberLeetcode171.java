package com.app.practice.strings;

import java.util.Scanner;

public class ExcelsheetColumnNumberLeetcode171 {
	private static int titleToNumber(String s) {
		int n = s.length();
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += (s.charAt(i) - 65 + 1) * Math.pow(26, (n - i - 1));
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.nextLine();
		
		int result = titleToNumber(txt);
		
		System.out.println(result);
		
		scanner.close();

	}

}
