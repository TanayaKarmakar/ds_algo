package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharactersLeetcode3 {
	private static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Map<Character, Integer> map = new HashMap<>();

		int i = 0;
		int maxLen = 1;
		for (int j = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Integer.max(i, map.get(s.charAt(j)));
			}
			maxLen = Integer.max(maxLen, (j - i) + 1);
			map.put(s.charAt(j), j + 1);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String txt = scanner.next();

		int ans = lengthOfLongestSubstring(txt);

		System.out.println(ans);

		scanner.close();
	}

}
