package com.app.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostTwoDistinctCharactersLeetcode159 {
	private static int longestSubstring(String s) {
		if(s.length() < 2)
			return 0;
		int n = s.length();
		int l = 0;
		int r = 0;
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		
		while(r < n) {
			char ch = s.charAt(r);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			while(l <= r && map.size() > 2) {
				if(maxLen < (r - l)) {
					maxLen = (r - l);
				}
				ch = s.charAt(l);
				int val = map.get(ch);
				
				if(val == 1) {
					map.remove(ch);
				} else {
					map.put(ch, --val);
				}
				l++;
			}
			r++;
		}
		if(maxLen < (r - l))
			maxLen = (r - l);
		
		return maxLen;
	}

	public static void main(String[] args) {
		String str = "eceba";
		System.out.println(longestSubstring(str));
		
		str = "ccaabbb";
		System.out.println(longestSubstring(str));	
	}
}
