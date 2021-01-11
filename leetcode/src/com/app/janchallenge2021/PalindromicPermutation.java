package com.app.janchallenge2021;

import java.util.Scanner;

public class PalindromicPermutation {
	private static boolean canPermutePalindrome(String s) {
		if (s.length() <= 1)
			return true;
		int[] freq = new int[256];

		int n = s.length();

		for (int i = 0; i < n; i++) {
			freq[s.charAt(i)]++;
		}

		int oddCharCount = 0;
		for (int i = 0; i < 256; i++) {
			if (freq[i] == 0)
				continue;
			if (freq[i] % 2 != 0)
				oddCharCount++;
		}

		return oddCharCount <= 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		boolean isPossible = canPermutePalindrome(str);
		
		System.out.println(isPossible);
		
		scanner.close();

	}

}
