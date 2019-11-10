package com.array.ideserve.practice;

import java.util.HashMap;
import java.util.Map;

public class AnagramPatternSearchPractice {
	private static boolean patternExists(String str, String pattern) {
		int windowSize = pattern.length();
		Map<Character, Integer> charMap = new HashMap<>();
		Map<Character, Integer> patternMap = new HashMap<>();
		createMap(pattern, patternMap);
		createMap(str.substring(0, windowSize), charMap);

		int start = 0;
		int end = windowSize - 1;

		while (end < str.length() && start < end) {
			if (isEqual(charMap, patternMap))
				return true;
			else {
				char targetChar = str.charAt(start);
				updateOrRemoveData(targetChar, charMap);
				start++;
				end++;
				if(end < str.length()) {
					addOrUpdateData(str.charAt(end), charMap);
				}	
			}
		}
		return false;
	}

	private static boolean isEqual(Map<Character, Integer> map1, Map<Character, Integer> map2) {
		for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
			char currentChar = entry.getKey();
			if (!map2.containsKey(currentChar))
				return false;
			else {
				int count1 = entry.getValue();
				int count2 = map2.get(currentChar);
				if (count1 != count2)
					return false;
			}
		}
		return true;
	}

	private static void updateOrRemoveData(Character targetChar, Map<Character, Integer> map) {
		int tmp = map.get(targetChar);
		tmp = tmp - 1;
		if (tmp == 0) {
			map.remove(targetChar);
		} else {
			map.put(targetChar, tmp);
		}
	}

	private static void addOrUpdateData(Character targetChar, Map<Character, Integer> map) {
		if (!map.containsKey(targetChar)) {
			map.put(targetChar, 1);
		} else {
			int tmp = map.get(targetChar);
			map.put(targetChar, ++tmp);
		}
	}

	private static void createMap(String str, Map<Character, Integer> map) {
		for (int i = 0; i < str.length(); i++) {
			addOrUpdateData(str.charAt(i), map);
		}
	}

	public static void main(String[] args) {
		String str = "ideserve";
		String pattern = "veer";
		System.out.println("Pattern exists between {" + str + ", " + pattern + "} - " + patternExists(str, pattern));
	
		str = "biology";
		pattern = "yolg";
		System.out.println("Pattern exists between {" + str + ", " + pattern + "} - " + patternExists(str, pattern));
		
		
		str = "algorithm";
		pattern = "rythm";
		System.out.println("Pattern exists between {" + str + ", " + pattern + "} - " + patternExists(str, pattern));
	}

}
