package com.app.string.practice;

public class LexicographicOrderOfString {
	private static void populateAndUpdateCount(String str, int[] count) {
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}

		for (int i = 1; i < 256; i++) {
			count[i] += count[i - 1];
		}
	}

	private static int fact(int n) {
		if (n <= 1)
			return n;
		return n * fact(n - 1);
	}

	private static void decreaseCount(int[] count, char ch) {
		for (int i = ch; i < 256; i++) {
			count[i]--;
		}
	}

	private static int lexicoGraphicOrdering(String str) {
		int[] count = new int[256];

		populateAndUpdateCount(str, count);

		int n = str.length();

		int mul = fact(str.length());

		int res = 1;

		for (int i = 0; i < n; i++) {
			mul = mul / (n - i);

			res += count[str.charAt(i) - 1] * mul;

			decreaseCount(count, str.charAt(i));
		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println("Lexicographic order - " 
				+ lexicoGraphicOrdering("string"));
	}

}
