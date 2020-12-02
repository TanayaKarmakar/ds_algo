package com.app.practice.math;

public class CalculatePowerLeetcode50 {
	private static double myPow(double x, int n) {
		long b = n;
        if (b < 0) {
			x = 1 / x;
			b = Math.abs(b);
		}

		double result = 1;
		while (b != 0) {
			if ((b & 1) == 1)
				result = result * x;
			x = x * x;
			b = b >> 1;
		}

		return result;
	}

	public static void main(String[] args) {
		int x = 2;
		int n = -2;

		double ans = myPow(x, n);

		System.out.println(ans);

	}

}
