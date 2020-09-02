package com.app.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringWithAtmostKDistinctCharsLeetcode340 {
	private static int lengthOfLongestSubstringKDistinct(String s, int k) {
		int n = s.length();
		int l = 0;
		int r = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		int maxLen = 0;
		while(r < n) {
			char ch = s.charAt(r);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			
			while(l <= r && map.size() > k) {
				if((r - l) > maxLen)
					maxLen = (r - l);
				char ch1 = s.charAt(l);
				map.put(ch1, map.get(ch1) - 1);
				if(map.get(ch1) == 0)
					map.remove(ch1);
				l++;
			}
			r++;
		}
		
		if(map.size() <= k) {
			maxLen = Integer.max(maxLen, (r - l));
		}
		
		return maxLen;
	}

	public static void main(String[] args) {
		String s = "eceba";
		
		System.out.println(lengthOfLongestSubstringKDistinct(s, 2));
		
		s = "aa";
		
		System.out.println(lengthOfLongestSubstringKDistinct(s, 1));

	}

}
