package com.app.practice.strings;

import java.util.Scanner;

public class StringToIntegerLeetcode8 {
	private static int myAtoi(String str) {
		if (str.length() == 0)
			return 0;
		str = str.trim();
		if (str.isEmpty())
			return 0;
		boolean isNeg = false;
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {
			if (str.charAt(0) == '-')
				isNeg = true;
			str = str.substring(1);
		} else if (!Character.isDigit(str.charAt(0)))
			return 0;
		String[] strs = str.split("\\s+");
		str = strs[0].trim();
		long sum = 0;
		int n = str.length();

		for (int i = 0; i < n; i++) {
			if (!Character.isDigit(str.charAt(i)))
				break;
			sum = sum * 10 + (str.charAt(i) - '0');
			if (sum > Integer.MAX_VALUE) {
				if (isNeg)
					return Integer.MIN_VALUE;
				return Integer.MAX_VALUE;
			}
		}
		if (isNeg)
			return -(int) sum;
		return (int) sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.next();

		int ans = myAtoi(txt);

		System.out.println(ans);
		scanner.close();
	}

}
