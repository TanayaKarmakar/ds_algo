package com.app.questions.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	private static int longestSubstring(String str) {
		return 0;
//		Map<Character, Integer> map = new LinkedHashMap<>();
//		int n = str.length();
//		int maxLen = Integer.MIN_VALUE;
//		int currentLen = 0;
//		for(int i = 0; i < n; i++) {
//			char ch = str.charAt(i);
//			if(!map.containsKey(ch)) {
//				map.put(ch, i);
//				currentLen++;
//			} else {
//				
//			}
//		}
	}

	public static void main(String[] args) {
		System.out.println(longestSubstring("abcabcbb"));
		System.out.println(longestSubstring("bbbbb"));
		System.out.println(longestSubstring("pwwkew"));
		System.out.println(longestSubstring("ckilbkd"));

	}

}
