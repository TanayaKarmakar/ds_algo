package com.app.stringalgo.problems;

public class KMPPatternSearch {
	private static int[] getLps(String pattern) {
		int n = pattern.length();
		int[] lps = new int[n];
		lps[0] = 0;
		int j = 0;
		int i = 1;
		while (i < n) {
			if (pattern.charAt(j) == pattern.charAt(i)) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	private static boolean kmpSearch(String str, String pattern) {
		int txtLen = str.length();
		int pattLen = pattern.length();

		int[] lps = getLps(pattern);

		int i = 0;
		int j = 0;
		while (i < txtLen && j < pattLen) {
			if (str.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}

		if (j == pattLen)
			return true;
		return false;
	}

	public static void main(String[] args) {
		String str = "abcdabczabadabcdabcy";
		String pattern = "abcdabcy";

		System.out.println(kmpSearch(str, pattern));

		pattern = "abcdabcx";

		System.out.println(kmpSearch(str, pattern));

	}

}
