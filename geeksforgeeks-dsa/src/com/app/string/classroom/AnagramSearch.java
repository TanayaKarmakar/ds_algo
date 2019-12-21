package com.app.string.classroom;

import java.util.HashMap;
import java.util.Map;

//using hashmap
public class AnagramSearch {
	private static boolean isAnagramPresent(String txt, String pattern) {
		int windowSize = pattern.length();
		
		Map<Character, Integer> patternMap = new HashMap<>();
		insertData(pattern, patternMap);
		
		Map<Character, Integer> charMap = new HashMap<>();
		insertData(txt.substring(0, windowSize), charMap);
		
		int n = txt.length();
		int start = 0;
		
		while(start < n && (start + windowSize) < n) {
			if(checkIfSameSequence(charMap, patternMap))
				return true;
			else {
				updateOrRemoveEntry(txt.charAt(start), charMap);
				if((start + windowSize) < n) {
					insertEntry(txt.charAt(start + windowSize), charMap);
				}
				start++;
			}
		}
		
		return false;
	}
	
	private static boolean checkIfSameSequence(Map<Character, Integer> map1,
			Map<Character, Integer> map2) {
		for(Map.Entry<Character, Integer> entry: map1.entrySet()) {
			char ch = entry.getKey();
			int freq = entry.getValue();
			
			if(!map2.containsKey(ch)) 
				return false;
			else {
				int freq2 = map2.get(ch);
				if(freq != freq2)
					return false;
			}
		}
		return true;
	}
	
	private static void insertData(String str, Map<Character, Integer> map) {
		for(int i = 0;i<str.length();i++) {
			insertEntry(str.charAt(i), map);
		}
	}
	
	private static void insertEntry(Character ch, Map<Character, Integer> map) {
		if(!map.containsKey(ch)) {
			map.put(ch, 1);
		} else {
			int tmp = map.get(ch);
			map.put(ch, ++tmp);
		}
	}
	
	private static void updateOrRemoveEntry(Character ch, Map<Character, Integer> map) {
		int tmp = map.get(ch);
		--tmp;
		if(tmp == 0) {
			map.remove(ch);
		} else {
			map.put(ch, tmp);
		}
	}

	public static void main(String[] args) {
		System.out.println("Is Anagram present - " + 
				isAnagramPresent("geeksforgeeks", "egek"));
		
		System.out.println("Is Anagram present - " + 
				isAnagramPresent("geeksforgeeks", "gks"));

	}

}
