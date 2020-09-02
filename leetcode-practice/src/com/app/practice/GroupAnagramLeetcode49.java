package com.app.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramLeetcode49 {
	private static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String temp = new String(arr);
			if(!map.containsKey(temp)) {
				List<String> values = new ArrayList<>();
				values.add(str);
				map.put(temp, values);
			} else {
				map.get(temp).add(str);
			}
		}

		List<List<String>> res = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
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
