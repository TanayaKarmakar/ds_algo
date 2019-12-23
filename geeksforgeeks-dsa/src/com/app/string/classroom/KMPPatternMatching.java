package com.app.string.classroom;

import java.util.Arrays;

public class KMPPatternMatching {
	private static void matchString(String txt, String pattern) {
		int[] lps = constructLPSArray(pattern);
		
		int n = txt.length();
		int m = pattern.length();
		
		int i = 0;
		int j = 0;
		while(i < n) {
			if(txt.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			if(j == m) {
				System.out.println("Pattern found at index - " + (i - j));
				j = lps[j - 1];
			}
			else if(i < n && txt.charAt(i) != pattern.charAt(j)) {
				if(j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
	}
	private static int[] constructLPSArray(String pattern) {
		int m = pattern.length();
		int i = 0;
		int j = 1;
		int[] lps = new int[m];
		while(j < m) {
			if(pattern.charAt(i) == pattern.charAt(j)) {
				++i;
				lps[j] = i;
				j++;
			} else {
				if(i != 0) {
					i = lps[i - 1];
				} else {
					lps[j] = i;
					j++;
				}
			}
		}
		return lps;
	}

	public static void main(String[] args) {
//		String pattern = "acacabacacabacacac";
//		int[] lps = constructLPSArray(pattern);
//		
//		System.out.println("LPS Array - ");
//		System.out.println(Arrays.toString(lps));
		
		String txt = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		
		
		matchString(txt, pattern);
	}

}
