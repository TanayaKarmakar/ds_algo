package com.app.strings;

import java.util.Scanner;

public class ExcelSheetColumnNumber {
	private static int calculateNumber(String columnNumber) {
		int res = 0;
		int n = columnNumber.length();

		for (int i = 0; i < n; i++) {
			int val = columnNumber.charAt(i) - 65 + 1;
			res = res + val * (int) Math.pow(26, n - i - 1);
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String columnNumber = scanner.next();

		int res = calculateNumber(columnNumber);

		System.out.println(res);

		scanner.close();

	}

}
