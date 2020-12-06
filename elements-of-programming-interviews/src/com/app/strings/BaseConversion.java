package com.app.strings;

public class BaseConversion {
	private static int convertToInt(String numStr, int b1) {
		int num = 0;
		int n = numStr.length();
		for (int i = 0; i < n; i++) {
			int val = 0;
			if (Character.isDigit(numStr.charAt(i))) {
				val = numStr.charAt(i) - '0';
			} else {
				val = numStr.charAt(i) - 'A' + 10;
			}
			num = num * b1 + val;
		}
		return num;
	}

	private static String baseConversion(String numStr, int b1, int b2) {
		boolean isNeg = false;
		if (numStr.charAt(0) == '-') {
			isNeg = true;
			numStr = numStr.substring(1);
		}
		int num = convertToInt(numStr, b1);
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			int rem = num % b2;
			if (rem >= 10) {
				sb.insert(0, (char) ('A' + rem - 10));
			} else {
				sb.insert(0, (char) (rem + '0'));
			}
			num = num / b2;
		}
		if (isNeg) {
			sb.insert(0, '-');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "-615";

		String ans = baseConversion(str, 7, 13);

		System.out.println(ans);

	}

}
