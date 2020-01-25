package com.app.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	private static String getSortedString(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	private static void groupAnagrams(String[] strs) {
		Map<String, List<String>> wordMap = new LinkedHashMap<>();
		
		for(String str: strs) {
			String sStr = getSortedString(str);
			if(!wordMap.containsKey(sStr)) {
				List<String> values = new ArrayList<>();
				values.add(str);
				wordMap.put(sStr, values);
			} else {
				wordMap.get(sStr).add(str);
			}
		}
		
		Collection<List<String>> valueSet = wordMap.values();
		List<List<String>> finalValueSet = new ArrayList<>(valueSet);
		System.out.println(finalValueSet);
	}

	public static void main(String[] args) {
		String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		groupAnagrams(str);
	}

}
