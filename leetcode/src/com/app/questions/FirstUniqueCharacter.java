package com.app.questions;

import java.util.Arrays;

public class FirstUniqueCharacter {
	public static int firstUniqueChar(String s) {
		int[] chars = new int[256];
		Arrays.fill(chars, -1);

		int n = s.length();
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (chars[ch] == -1) {
				chars[ch] = i;
			} else {
				chars[ch] = -2;
			}
		}

		int indx = Integer.MAX_VALUE;
		for (int i = 0; i < 256; i++) {
			if (chars[i] >= 0) {
				indx = Integer.min(indx, chars[i]);
			}
		}

		return indx == Integer.MAX_VALUE ? -1 : indx;
	}

	public static void main(String[] args) {
		String str = "leetcode";

		System.out.println(firstUniqueChar(str));

		str = "loveleetcode";

		System.out.println(firstUniqueChar(str));

	}

}
