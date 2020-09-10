package com.app.companywise.google;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepitition {
	private static int longestSubstring(String s) {
		List<String> substring = new ArrayList<>();
		int result = 0;
		for (int indx = 0; indx < s.length(); indx++) {
			int j = indx;
			while (j < s.length() && !substring.contains(String.valueOf(s.charAt(j)))) {
				substring.add(String.valueOf(s.charAt(j)));
				j++;
			}

			if (result < substring.size()) {
				result = substring.size();
			}
			substring.clear();
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstring("abcabcabc"));
		System.out.println(longestSubstring("bbbbbb"));
		System.out.println(longestSubstring("pwwkew"));
		System.out.println(longestSubstring("au"));
		System.out.println(longestSubstring("aab"));
	}

}
