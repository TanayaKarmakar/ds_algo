package com.app.questions.strings;

public class StringToIntegerLeetcode8 {
	private static int myAtoi(String s) {
		String str = s.trim().split("\\s+")[0];
		if (str.length() == 0)
			return 0;
	
		boolean isNeg = false;
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {
			if (str.charAt(0) == '-')
				isNeg = true;
			str = str.substring(1);
		} else if (!Character.isDigit(str.charAt(0))) {
			return 0;
		}

		long res = 0;
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)))
				break;
			int digit = str.charAt(i) - '0';
			res = res * 10 + digit;
			if (res > Integer.MAX_VALUE) {
				if (isNeg)
					return Integer.MIN_VALUE;
				return Integer.MAX_VALUE;
			}
		}

		if (isNeg)
			res = -res;

		return (int) res;
	}

	public static void main(String[] args) {

	}

}
