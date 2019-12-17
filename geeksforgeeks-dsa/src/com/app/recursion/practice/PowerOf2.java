package com.app.recursion.practice;

public class PowerOf2 {
	private static int powerOf2(int k) {
		if (k == 0)
			return 1;
		return 2 * powerOf2(k - 1);
	}

	public static void main(String[] args) {
		int n = 10;
		for (int i = 1; i <= n; i++) {
			System.out.println(i + "th power of 2 is " + powerOf2(i));
		}
	}
}
