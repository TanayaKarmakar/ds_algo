package com.app.string.practice;

import java.util.Arrays;

public class FirstNonRepeatingIndex {
	private static int getIndex(String str) {
		int[] freq = new int[256];
		Arrays.fill(freq, -1);

		int n = str.length();
		for (int i = 0; i < n; i++) {
			int ch = str.charAt(i);
			if (freq[ch] == -1) {
				freq[ch] = i;
			} else {
				freq[ch] = -2;
			}
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 256; i++) {
			if (freq[i] >= 0) {
				res = Integer.min(res, freq[i]);
			}
		}

		if (res == Integer.MAX_VALUE)
			res = -1;

		return res;
		//return (res == -1)? Character.va"-1" : str.charAt(res);
	}

	public static void main(String[] args) {
		String str = "hello";
		
		System.out.println("Non repeating char index - " + getIndex(str));
		
		str = "zxvczbtxyzvy";
		
		System.out.println("Non repeating char index - " + getIndex(str));

	}

}
