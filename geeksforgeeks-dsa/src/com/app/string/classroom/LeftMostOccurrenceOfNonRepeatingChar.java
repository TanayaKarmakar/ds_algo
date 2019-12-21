package com.app.string.classroom;

import java.util.Arrays;

public class LeftMostOccurrenceOfNonRepeatingChar {
	private static int leftMostIndx(String str) {
		int[] freq = new int[256];
		int n = str.length();

		Arrays.fill(freq, -1);
		for (int i = 0; i < n; i++) {
			if (freq[str.charAt(i)] == -1) {
				freq[str.charAt(i)] = i;
			} else {
				freq[str.charAt(i)] = -2;
			}
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 256; i++) {
			if (freq[i] >= 0) {
				res = Integer.min(res, freq[i]);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(leftMostIndx("geeksforgeeks"));
	}

}
