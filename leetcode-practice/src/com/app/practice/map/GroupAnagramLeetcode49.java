package com.app.practice.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramLeetcode49 {
	private static String sort(String str) {
		char[] cStr = str.toCharArray();
		Arrays.sort(cStr);
		return new String(cStr);
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String key = sort(str);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}

		List<List<String>> res = new ArrayList<>();

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
			res.add(entry.getValue());
		}

		return res;
	}

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = groupAnagrams(strs);
		
		System.out.println(res);
	}

}
