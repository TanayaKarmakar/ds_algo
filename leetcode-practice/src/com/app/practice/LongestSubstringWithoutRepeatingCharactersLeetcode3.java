package com.app.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersLeetcode3 {
	private static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Map<Character, Integer> map = new HashMap<>();
		
		int i = 0;
		int j = 0;
		int ans = 0;
		for(j = 0; j < n; j++) {
			if(map.containsKey(s.charAt(j))) {
				i = Integer.max(map.get(s.charAt(j)), i);
			}
			ans = Integer.max(ans, (j - i) + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		String str = "abcabcbb";
		
		System.out.println(lengthOfLongestSubstring(str));
		
		str = "bbbbb";
		
		System.out.println(lengthOfLongestSubstring(str));
		
		str = "pwwkew";
		
		System.out.println(lengthOfLongestSubstring(str));

	}

}
