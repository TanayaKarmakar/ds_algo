package com.app.recursion.practice;

public class KthOddNumber {
	private static int findKthOddNumber(int k) {
		if (k == 1)
			return 1;
		return findKthOddNumber(k - 1) + 2;
	}

	public static void main(String[] args) {
		int n = 10;
		for (int i = 1; i <= n; i++) {
			System.out.println(i + "th odd number - " + findKthOddNumber(i));
		}
	}
}
