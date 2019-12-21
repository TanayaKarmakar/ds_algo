package com.app.string.classroom;

public class LexicographicOrder {
	private static void updateCount(int[] freq, String str) {
		for (int i = 0; i < str.length(); i++) {
			freq[(int)str.charAt(i)]++;
		}

		for (int i = 1; i < 256; i++) {
			freq[i] += freq[i - 1];
		}
	}

	private static int fact(int n) {
		if (n <= 1)
			return 1;
		return n * fact(n - 1);
	}

	private static void decreaseCount(int[] count, char ch) {
		for (int i = ch; i < 256; i++) {
			count[i]--;
		}
	}

	private static int lexicoGraphicOrder(String str) {
		int n = str.length();

		int[] freq = new int[256];
		updateCount(freq, str);

		int mul = fact(n);
		int res = 1;

		for (int i = 0; i < n; i++) {
			mul = mul / (n - i);
			res += freq[(int)str.charAt(i) - 1] * mul;
			decreaseCount(freq, str.charAt(i));
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("Lexicographical "
				+ "Order - " + lexicoGraphicOrder("string"));
	}

}
