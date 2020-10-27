package com.app.questions.hashtable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1.length() == o2.length())
			return o1.compareTo(o2);
		return o1.length() - o2.length();
	}
}

public class GroupShiftedStringLeetcode249 {
	private static String getHash(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int val1 = str.charAt(i) - '0';
			int val2 = str.charAt(0) - '0';
			int result = ((val1 - val2) + 26) % 26;
			sb.append(result + " ");
		}

		return sb.toString();
	}

	private static List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strings) {
			String hash = getHash(str);
			if (!map.containsKey(hash)) {
				map.put(hash, new ArrayList<>());
			}
			map.get(hash).add(str);
		}
		
		System.out.println(map);

		List<List<String>> result = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			List<String> values = new ArrayList<>();
			values.addAll(entry.getValue());
			result.add(values);
		}

		return result;
	}

	public static void main(String[] args) {
		String[] strings = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
		
		List<List<String>> result = groupStrings(strings);
		
		System.out.println(result);
	}

}
