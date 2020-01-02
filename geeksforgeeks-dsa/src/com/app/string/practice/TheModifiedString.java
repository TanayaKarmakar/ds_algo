package com.app.string.practice;

public class TheModifiedString {
	private static int minimumCharsInserted(String str) {
		int n = str.length();
		int charsInserted = 0;
		int count = 1;
		int i = 0;
		while (i < n) {
			if ((i + 1) < n) {
				if (str.charAt(i) == str.charAt(i + 1)) {
					if (count % 2 == 0)
						charsInserted++;
					count++;
				} else {
					count = 1;
				}
			}
			i++;
		}
		return charsInserted;
	}

	public static void main(String[] args) {
		String str = "aaaaa";

		System.out.println("Chars inserted - " + minimumCharsInserted(str));

		str = "aaaaaa";
		System.out.println("Chars inserted - " + minimumCharsInserted(str));

		str = "aaaaaaa";
		System.out.println("Chars inserted - " + minimumCharsInserted(str));

		str = "aabbbcc";
		System.out.println("Chars inserted - " + minimumCharsInserted(str));

		str = "abcddee";
		System.out.println("Chars inserted - " + minimumCharsInserted(str));

	}

}
