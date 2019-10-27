package com.array.ideserve;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringWithMCharacter {
	private static String findLargestSubstring(String string, int m) {
		char[] arr = string.toCharArray();
		int n = arr.length;

		int start = 0;
		int end = 0;

		int windowStart = 0;
		int windowSize = end - start + 1;

		Map<Character, Integer> charMap = new HashMap<>();
		charMap.put(arr[0], 1);

		for (int i = 1; i < n; i++) {
			if (charMap.get(arr[i]) == null) {
				charMap.put(arr[i], 1);
			} else {
				int tmp = charMap.get(arr[i]);
				charMap.put(arr[i], ++tmp);
			}
			end++;
			while (!isLessThanM(charMap, m)) {
				char currentChar = arr[start];
				int tmp = charMap.get(currentChar);

				charMap.put(currentChar, --tmp);

				start++;
			}
			if (windowSize < (end - start + 1)) {
				windowSize = end - start + 1;
				windowStart = start;
			}

		}

		return string.substring(windowStart, windowStart + windowSize);
	}

	private static boolean isLessThanM(Map<Character, Integer> charMap, int m) {
		int count = 0;
		for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
			int val = entry.getValue();
			if (val > 0)
				count++;
		}

		return count <= m;
	}

	public static void main(String[] args) {
		String str = "tanaya";
		int m = 3;
		System.out.println(findLargestSubstring(str, m));

	}

}
