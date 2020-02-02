package com.app.questions;

public class StringToInteger {
	private static int myAtoi(String str) {
		int startIndx = 0;
		int n = str.length();

		while (str.charAt(startIndx) == ' ' && startIndx < n) {
			startIndx++;
		}

		int num = 0;
		boolean neg = false;
		if (startIndx < n && (str.charAt(startIndx) == '+' || str.charAt(startIndx) == '-')) {
			if (str.charAt(startIndx) == '-') {
				neg = true;
			}
			startIndx++;
		}

		for (int i = startIndx; i < n; i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9')
				break;
			else if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > 7))
				return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;

			num = num * 10 + (str.charAt(i) - '0');
		}

		if (neg) {
			num = num * -1;
		}

		return num;
	}

	public static void main(String[] args) {
		/*String str = "42";

		System.out.println(myAtoi(str));

		str = "     -42";

		System.out.println(myAtoi(str));

		str = "4193 with words";

		System.out.println(myAtoi(str));

		str = "words and 987";

		System.out.println(myAtoi(str));

		str = "-91283472332";

		System.out.println(myAtoi(str));

		str = "3.14159";

		System.out.println(myAtoi(str));

		str = "+-2";

		System.out.println(myAtoi(str));*/
		
		String str = "2147483648";
		
		System.out.println(myAtoi(str));

	}

}
