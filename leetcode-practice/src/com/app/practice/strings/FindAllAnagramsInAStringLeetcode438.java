package com.app.practice.strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAStringLeetcode438 {
	private static boolean isEqual(int[] sFreq, int[] pFreq) {
		for (int i = 0; i < 26; i++) {
			if (sFreq[i] != pFreq[i])
				return false;
		}
		return true;
	}

	private static List<Integer> findAnagrams(String s, String p) {
		if(s.length() == 0 || p.length() == 0)
			return new ArrayList<>();
		int m = s.length();
		int windowSize = p.length();
		int l = 0;
		int r = 0;

		List<Integer> res = new ArrayList<>();

		int[] sFreq = new int[26];
		int[] pFreq = new int[26];
		for (int i = 0; i < windowSize; i++) {
			int pVal = p.charAt(i) - 'a';
			pFreq[pVal]++;
		}
		
		for(r = 0; r < Integer.min(m, windowSize); r++) {
			int sVal = s.charAt(r) - 'a';
			sFreq[sVal]++;
		}

		while (r < m) {
			if (isEqual(sFreq, pFreq)) {
				res.add(l);
			}
			int lVal = s.charAt(l) - 'a';
			int rVal = s.charAt(r) - 'a';
			sFreq[lVal]--;
			sFreq[rVal]++;
			l++;
			r++;
		}
		
		if(isEqual(sFreq, pFreq))
			res.add(l);
		
		return res;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		
		List<Integer> result = findAnagrams(s, p);
		System.out.println(result);
		
		s = "abab";
		p = "ab";
		
		result = findAnagrams(s, p);
		System.out.println(result);
	}

}
