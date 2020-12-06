package com.app.strings;

public class FindTheStartIndexOfSubstring {
	private static int[] getLPS(String pattern) {
		int n = pattern.length();
		int[] lps = new int[n];
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
					i++;
				}
			}
		}

		return lps;
	}

	private static int findStartIndx(String target, String pattern) {
		int[] lps = getLPS(pattern);

		int m = target.length();
		int n = pattern.length();

		int i = 0;
		int j = 0;

		int startIndx = -1;

		while (i < m) {
			if (target.charAt(i) == pattern.charAt(j)) {
				if (startIndx == -1)
					startIndx = i;
				i++;
				j++;
				if (j == n)
					return startIndx;
			} else {
				startIndx = -1;
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String target = "I love coding";
		String pattern = "coding";
		
		int ans = findStartIndx(target, pattern);
		
		System.out.println(ans);
	}

}
