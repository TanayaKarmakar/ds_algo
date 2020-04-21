package com.app.questions.practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqueCharactersInaStringLeetcode387 {
	private static int firstUniqueChar(String s) {
		Map<Character, List<Integer>> map = new LinkedHashMap<>();
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if(!map.containsKey(ch)) {
				List<Integer> res = new ArrayList<>();
				res.add(i);
				map.put(ch, res);
			} else {
				map.get(ch).add(i);
			}
		}
		
		for(Map.Entry<Character, List<Integer>> entry: map.entrySet()) {
			if(entry.getValue().size() == 1)
				return entry.getValue().get(0);
		}
		
		return -1;
	}

	public static void main(String[] args) {
		String str1 = "leetcode";
		String str2 = "loveleetcode";
		
		System.out.println(firstUniqueChar(str1));
		System.out.println(firstUniqueChar(str2));

	}

}
