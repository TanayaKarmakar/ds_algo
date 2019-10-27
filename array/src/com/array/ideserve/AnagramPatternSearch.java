package com.array.ideserve;

import java.util.HashMap;
import java.util.Map;

public class AnagramPatternSearch {
	private static boolean patternSearch(String str, String pattern) {
		Map<Character, Integer> strMap = new HashMap<>();
		Map<Character, Integer> patternMap = new HashMap<>();
		populateMap(pattern, patternMap);
		int windowSize = pattern.length();
		populateMap(str.substring(0, windowSize), strMap);
		int start = 0;
		int end = windowSize - 1;
		while (end < str.length() && start < end && !isEqual(strMap, patternMap)) {
			char charToBeRemoved = str.charAt(start);
			updateData(strMap, charToBeRemoved);
			start++;
			end++;
			if (end < str.length()) {
				putData(strMap, str.charAt(end));
			}

		}
		return isEqual(strMap, patternMap);
	}

	private static boolean isEqual(Map<Character, Integer> strMap, Map<Character, Integer> patternMap) {
		if (strMap.keySet().size() != patternMap.keySet().size())
			return false;
		for (Map.Entry<Character, Integer> entry : strMap.entrySet()) {
			Character key = entry.getKey();
			if (!patternMap.containsKey(key))
				return false;
			else {
				int val1 = entry.getValue();
				int val2 = patternMap.get(key);
				if(val1 != val2)
					return false;
			}
		}
		return true;
	}

	private static void populateMap(String str, Map<Character, Integer> map) {
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			putData(map, currentChar);
		}
	}

	private static void putData(Map<Character, Integer> map, Character item) {
		if (!map.containsKey(item)) {
			map.put(item, 1);
		} else {
			int tmp = map.get(item);
			map.put(item, ++tmp);
		}
	}

	private static void updateData(Map<Character, Integer> map, Character item) {
		int tmp = map.get(item);
		if (tmp == 1) {
			map.remove(item);
		} else {
			map.put(item, --tmp);
		}
	}

	public static void main(String[] args) {
		String str = "ideserve";
		String pattern = "veer";
		System.out.println(patternSearch(str, pattern));
		
		str = "tanaya";
		pattern = "map";
		System.out.println(patternSearch(str, pattern));
		
		str = "doctor";
		pattern = "oct";
		System.out.println(patternSearch(str, pattern));
				
	}

}
