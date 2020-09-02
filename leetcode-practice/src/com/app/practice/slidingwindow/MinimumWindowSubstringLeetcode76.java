package com.app.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringLeetcode76 {
	private static String minimumWindowSubstring(String s, String t) {
		Map<Character, Integer> tMap = new HashMap<>();
		
		for(int i = 0; i < t.length(); i++) {
			tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
		}
		
		Map<Character, Integer> sMap = new HashMap<>();
		int required = tMap.size();
		int formed = 0;
		
		int n = s.length();
		int l = 0;
		int r = 0;
		
		int left = -1;
		int right = -1;
		int diff = n + 1;
		
		while(r < n) {
			char ch = s.charAt(r);
			sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
			if(tMap.containsKey(ch) && sMap.get(ch) == tMap.get(ch))
				formed++;
			
			while(l <= r && required == formed) {
				if(diff != -1 && r - l + 1 < diff) {
					left = l;
					right = r;
					diff = r - l + 1;
				}
				char ch1 = s.charAt(l);
				int val = sMap.get(ch1);
				sMap.put(ch1, --val);
				if(tMap.containsKey(ch1) && sMap.get(ch1) < tMap.get(ch1))
					formed--;
				l++;
			}
			
			r++;
		}
		
		
		return diff == n + 1 ? "": s.substring(left, right + 1);
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		
		System.out.println(minimumWindowSubstring(s, t));

	}

}
