package com.app.practice.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAStringLeetcode438 {
	private static int[] getFreq(String s, int start, int end) {
		int[] freq = new int[26];
		for(int i = start; i < end; i++) {
			freq[s.charAt(i) - 'a']++;
		}
		
		return freq;
	}
	
	private static boolean isEqual(int[] sFreq, int[] pFreq) {
		for(int i = 0; i < 26; i++) {
			if(sFreq[i] != pFreq[i])
				return false;
		}
		return true;
	}
	
	private static List<Integer> findAnagrams(String s, String p) {
		if(s.isEmpty())
			return new ArrayList<>();
		int n = s.length();
		int l = 0;
		int windowSize = p.length();
		int r = windowSize;
		
		int start = 0;
		
		List<Integer> res = new ArrayList<>();
		int[] pFreq = getFreq(p, 0, windowSize);
		int[] sFreq = getFreq(s, 0, Integer.min(s.length(), windowSize));
		
		while(r < n) {
			start = l;
			if(isEqual(sFreq, pFreq))
				res.add(start);
			sFreq[s.charAt(l) - 'a']--;
			sFreq[s.charAt(r) - 'a']++;
			l++;
			r++;
		}
		
		if(isEqual(sFreq, pFreq)) {
			res.add(l);
		}
		
		return res;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		
		List<Integer> res = findAnagrams(s, p);
		
		System.out.println(res);
		
		s = "abab";
		p = "ab";
		
		res = findAnagrams(s, p);
		
		System.out.println(res);
		
		s = "aaaaaaaaaa";
		p = "aaaaaaaaaaaaa";
		
		res = findAnagrams(s, p);
		
		System.out.println(res);
	}

}
