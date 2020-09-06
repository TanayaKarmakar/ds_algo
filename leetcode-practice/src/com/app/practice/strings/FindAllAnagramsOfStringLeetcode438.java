package com.app.practice.strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsOfStringLeetcode438 {
	private static boolean isEqual(int[] sFreq, int[] tFreq) {
		for (int i = 0; i < 26; i++) {
			if (sFreq[i] != tFreq[i])
				return false;
		}
		return true;
	}

	private static List<Integer> findAnagrams(String s, String p) {
		if(s.length() == 0)
			return new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		int[] sFreq = new int[26];
		int[] pFreq = new int[26];

		int k = p.length();
		int n = s.length();

		int l = 0;
		int r = 0;
		
		for(int i = 0; i < k; i++) {
			pFreq[p.charAt(i) - 'a']++;
		}
		
		for(r = 0; r < Integer.min(n, k); r++) {
			sFreq[s.charAt(r) - 'a']++;
		}

		while (r < n) {
			if (isEqual(sFreq, pFreq))
				res.add(l);
			int lChar = s.charAt(l) - 'a';
			int rChar = s.charAt(r) - 'a';
			sFreq[lChar]--;
			sFreq[rChar]++;
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
		
		List<Integer> res = findAnagrams(s, p);
		System.out.println(res);
	}

}
