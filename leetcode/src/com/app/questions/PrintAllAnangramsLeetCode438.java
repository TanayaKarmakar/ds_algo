package com.app.questions;

import java.util.ArrayList;
import java.util.List;

public class PrintAllAnangramsLeetCode438 {
	private static int[] getFreq(String str) {
		int[] freq = new int[256];
		int n = str.length();
		for (int i = 0; i < n; i++) {
			freq[str.charAt(i)]++;
		}
		return freq;
	}

	private static boolean isAnagram(String str, int[] pattFreq) {
		int[] strFreq = getFreq(str);

		for (int i = 0; i < 256; i++) {
			if (pattFreq[i] != strFreq[i])
				return false;
		}
		return true;
	}

	private static List<Integer> findAnagrams(String s, String p) {
		int windowSize = p.length();
		int n = s.length();
		int start = 0;
		List<Integer> res = new ArrayList<>();
		int[] pattFreq = getFreq(p);
		while (start < n) {
			if (start + windowSize <= n) {
				if (isAnagram(s.substring(start, start + windowSize), pattFreq))
					res.add(start);
			}
			start++;
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("abab", "ab"));
	}

}
