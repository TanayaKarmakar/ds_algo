package com.app.string.classroom;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	private static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		int n = str1.length();

		for (int i = 0; i < n; i++) {
			insertChar(str1.charAt(i), map1);
			insertChar(str2.charAt(i), map2);
		}

		for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
			char ch = entry.getKey();
			int freq = entry.getValue();

			if (!map2.containsKey(ch))
				return false;
			else {
				int freq2 = map2.get(ch);
				if (freq != freq2)
					return false;
			}
		}
		return true;
	}

	private static void insertChar(Character ch, Map<Character, Integer> map) {
		if (!map.containsKey(ch)) {
			map.put(ch, 1);
		} else {
			int tmp = map.get(ch);
			map.put(ch, ++tmp);
		}
	}

	public static void main(String[] args) {
		System.out.println("Is Anagram " + isAnagram("geeks", "ekegs"));
		System.out.println("Is Anagram " + isAnagram("aabcd", "abbcd"));
	}

}
