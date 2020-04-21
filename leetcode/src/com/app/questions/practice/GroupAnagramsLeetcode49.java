package com.app.questions.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsLeetcode49 {
	private static String getSortedString(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
	private static List<List<String>> groupAnagrams(String[] strings) {
		int n = strings.length;
		

		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String key = getSortedString(strings[i]);
			String value = strings[i];

			if (!map.containsKey(key)) {
				List<String> values = new ArrayList<>();
				values.add(value);
				map.put(key, values);
			} else {
				map.get(key).add(value);
			}
		}
		
		//system.out.println(map);
		
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		System.out.println(groupAnagrams(strings));
	}

}
