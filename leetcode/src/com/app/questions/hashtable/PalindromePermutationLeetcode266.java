package com.app.questions.hashtable;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutationLeetcode266 {
	private static boolean canPermutePalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int n = s.length();

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);

			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int oddCount = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 != 0)
				oddCount++;
		}

		return oddCount <= 1;
	}

	public static void main(String[] args) {
		String s = "code";
		
		System.out.println(canPermutePalindrome(s));
		
		s = "aab";
		
		System.out.println(canPermutePalindrome(s));

	}

}
