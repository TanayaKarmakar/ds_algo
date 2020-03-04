package com.app.questions;

import java.util.HashMap;
import java.util.Map;

public class PermutationString {
	private static boolean isEqual(Map<Character, Integer> map1, Map<Character, Integer> map2) {
		for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
			char key = entry.getKey();
			int value = entry.getValue();
			if (!map2.containsKey(key))
				return false;
			else {
				int value1 = map2.get(key);
				if (value != value1)
					return false;
			}
		}
		return true;
	}

	private static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int windowSize = s1.length();
		Map<Character, Integer> pattMap = createFrequencyMap(s1);
		int i = 0;
		int n = s2.length();
		while (i < n && (i + windowSize) <= n) {
			Map<Character, Integer> strMap = createFrequencyMap(s2.substring(i, i + windowSize));
			if (isEqual(pattMap, strMap))
				return true;
			i++;
		}
		return false;
	}

	private static Map<Character, Integer> createFrequencyMap(String str) {
		Map<Character, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (!freqMap.containsKey(str.charAt(i))) {
				freqMap.put(str.charAt(i), 1);
			} else {
				int tmp = freqMap.get(str.charAt(i));
				freqMap.put(str.charAt(i), ++tmp);
			}
		}
		return freqMap;
	}

	public static void main(String[] args) {
		System.out.println("Check Inclusion - " + checkInclusion("adc", "dcda"));
		System.out.println("Check Inclusion - " + checkInclusion("ab", "eidbaooo"));
		System.out.println("Check Inclusion - " + checkInclusion("ab", "eidboaoo"));

	}

}
