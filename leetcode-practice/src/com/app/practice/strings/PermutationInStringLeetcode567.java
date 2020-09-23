package com.app.practice.strings;

import java.util.Arrays;

public class PermutationInStringLeetcode567 {
	private static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int windowSize = s1.length();
		int[] s1Freq = new int[26];
		int[] s2Freq = new int[26];

		int n = s2.length();

		int i = 0;
		for (i = 0; i < windowSize; i++) {
			s1Freq[s1.charAt(i) - 'a']++;
			s2Freq[s2.charAt(i) - 'a']++;
		}

		if (Arrays.equals(s1Freq, s2Freq))
			return true;

		int j = 0;
		while (i < n) {
			s2Freq[s2.charAt(j) - 'a']--;
			s2Freq[s2.charAt(i) - 'a']++;
			if (Arrays.equals(s1Freq, s2Freq))
				return true;
			i++;
			j++;
		}

		return false;
	}

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidbaooo";

		boolean ans = checkInclusion(s1, s2);
		System.out.println(ans);
	}

}
