package com.app.practice.strings;

import java.util.Scanner;

public class PalindromicPermutationLeetcode266 {
	private static boolean canPermutePalindrome(String s) {
		if (s.length() <= 1)
			return true;
		int[] charFreq = new int[256];

		int n = s.length();
		for (int i = 0; i < n; i++) {
			charFreq[s.charAt(i)]++; 
		}

		int oddCount = 0;
		for (int i = 0; i < 256; i++) {
			if (charFreq[i] % 2 != 0)
				oddCount++;
		}

		return oddCount <= 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.next();

		System.out.println(canPermutePalindrome(txt));

		scanner.close();

	}

}
