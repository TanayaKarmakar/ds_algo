package com.app.dp1.problems;

public class SumOfSubstrings {
	private static final int MOD = 1000000007;

	private static int sumOfSubstrings(String s) {
		long lastValue = s.charAt(0) - '0';
		long totalSum = s.charAt(0) - '0';

		for (int i = 1; i < s.length(); i++) {
			lastValue = lastValue * 10 + (s.charAt(i) - '0') * (i + 1);
			lastValue = lastValue % MOD;
			totalSum = (totalSum + lastValue) % MOD;

		}
		return (int)totalSum;
	}

	public static void main(String[] args) {
		String str = "123";
		
		System.out.println(sumOfSubstrings(str));

	}

}
