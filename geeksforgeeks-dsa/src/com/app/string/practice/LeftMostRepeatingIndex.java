package com.app.string.practice;

import java.util.Arrays;

public class LeftMostRepeatingIndex {
	private static int findLeftMostIndx(String str) {
		int[] freq = new int[256];

		int n = str.length();
		int res = Integer.MAX_VALUE;

		Arrays.fill(freq, -1);

		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (freq[ch] == -1) {
				freq[ch] = i;
			} else {
				res = Integer.min(res, freq[ch]);
			}
		}
		if(res == Integer.MAX_VALUE) {
			res = -1;
		}
		
		return res;
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		
		System.out.println("Index - " + findLeftMostIndx(str));
		
		str = "abcd";
		
		System.out.println("Index - " + findLeftMostIndx(str));

	}

}
