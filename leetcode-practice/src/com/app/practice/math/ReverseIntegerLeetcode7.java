package com.app.practice.math;

public class ReverseIntegerLeetcode7 {
	private static int reverse(int x) {
		boolean isNeg = false;
		if (x < 0) {
			isNeg = true;
			x = Math.abs(x);
		}

		long result = 0;
		int tmp = x;

		while (tmp > 0) {
			int r = tmp % 10;
			result = result * 10 + r;

			if (result >= Integer.MAX_VALUE)
				break;
			tmp = tmp / 10;
		}

		if (result >= Integer.MAX_VALUE)
			return 0;

		if (isNeg)
			result = -result;

		return (int) result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
