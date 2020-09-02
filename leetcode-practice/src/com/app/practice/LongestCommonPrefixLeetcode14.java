package com.app.practice;

public class LongestCommonPrefixLeetcode14 {
	private static String lcpUtil(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int i = 0;
		int j = 0;

		StringBuilder sb = new StringBuilder();
		while (i < m && j < n) {
			if (str1.charAt(i) != str2.charAt(j)) {
				break;
			}
			sb.append(str1.charAt(i));
			i++;
			j++;
		}
		return sb.toString();
	}

	private static String lcp(String[] words, int start, int end) {
		if (start == end)
			return words[start];
		if (start < end) {
			int mid = (start + end) / 2;
			String str1 = lcp(words, start, mid);
			String str2 = lcp(words, mid + 1, end);
			return lcpUtil(str1, str2);
		}
		return "";
	}

	private static String longestCommonPrefix(String[] words) {
		return lcp(words, 0, words.length - 1);
	}

	public static void main(String[] args) {
		String[] words = { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix(words));

		words = new String[] { "dog", "racecar", "car" };
		System.out.println(longestCommonPrefix(words));
	}

}
