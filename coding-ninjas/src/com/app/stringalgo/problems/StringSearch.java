package com.app.stringalgo.problems;

import java.util.Scanner;

public class StringSearch {
	private static int[] getLps(String pattern) {
		int pLen = pattern.length();
		int[] lps = new int[pLen];

		int j = 0;
		int i = j + 1;
		while (i < pLen) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
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

	private static int findString(String str, String pattern) {
		int tLen = str.length();
		int pLen = pattern.length();

		int[] lps = getLps(pattern);

		int i = 0;
		int j = 0;
		int startIndx = -1;
		while (i < tLen && j < pLen) {
			if(str.charAt(i) == pattern.charAt(j)) {
				if(startIndx == -1)
					startIndx = i;
				i++;
				j++;
				if(j == pLen)
					return startIndx;
			} else {
				startIndx = -1;
				if(j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
			
		}
		return startIndx;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		String pattern = scanner.next();
		
		int indx = findString(str, pattern);
		
		System.out.println(indx);

		scanner.close();
	}
}
