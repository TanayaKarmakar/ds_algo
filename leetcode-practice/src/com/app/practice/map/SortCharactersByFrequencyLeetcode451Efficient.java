package com.app.practice.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequencyLeetcode451Efficient {
	private static String frequencySort(String s) {
		if(s.equals(""))
			return "";
		Map<Character, Integer> map = new HashMap<>();
		int n = s.length();

		for (int i = 0; i < n; i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		int maxValue = Collections.max(map.values());

		List<List<Character>> bucket = new ArrayList<>();
		for (int i = 0; i <= maxValue; i++) {
			bucket.add(new ArrayList<>());
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			char key = entry.getKey();
			bucket.get(value).add(key);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = bucket.size() - 1; i >= 0; i--) {
			for (Character c : bucket.get(i)) {
				for (int j = 0; j < i; j++) {
					sb.append(c);
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String ans = frequencySort("tree");
		
		System.out.println(ans);

	}

}
