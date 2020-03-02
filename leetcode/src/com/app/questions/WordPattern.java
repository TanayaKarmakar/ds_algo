package com.app.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordPattern {
	private static boolean wordPattern(String pattern, String str) {
		String[] strArr = str.split("\\s+");
		if(pattern.length() != strArr.length)
			return false;
		Map<Character, String> map = new HashMap<>();
		int n = pattern.length();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(pattern.charAt(i))) {
				map.put(pattern.charAt(i), strArr[i]);
			} else {
				String val = map.get(pattern.charAt(i));
				if (!val.equals(strArr[i]))
					return false;
			}
		}
		
		if(map.size() != new HashSet<>(map.values()).size())
			return false;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			char currentChar = pattern.charAt(i);
			String val = map.get(currentChar);
			sb.append(val + " ");
		}
		return str.equals(sb.toString().trim());
	}

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));

	}

}
