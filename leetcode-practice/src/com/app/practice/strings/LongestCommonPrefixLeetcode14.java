package com.app.practice.strings;

public class LongestCommonPrefixLeetcode14 {
	private static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0)
			return "";
		String prefix = strs[0];
		for(String str: strs) {
			while(!str.startsWith(prefix)) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		
		return prefix;
	}

	public static void main(String[] args) {
		String[] words = { "flower", "flow", "flight" };
		String str = longestCommonPrefix(words);

		System.out.println(str);

		words = new String[] { "dog", "racecar", "car" };
		
		str = longestCommonPrefix(words);

		System.out.println(str);
	}

}
