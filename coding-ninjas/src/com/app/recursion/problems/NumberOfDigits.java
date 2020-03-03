package com.app.recursion.problems;

public class NumberOfDigits {
	private static int digits(int n) {
		if(n == 0)
			return 0;
		int smallOutput = digits(n / 10);
		return smallOutput + 1;
	}

	public static void main(String[] args) {
		int n = 156;
		System.out.println(digits(n));
		
		n = 1;
		System.out.println(digits(n));
	}

}
