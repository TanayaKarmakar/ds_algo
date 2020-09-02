package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;

public class WordPatternLeetcode290 {
	private static boolean wordPattern(String pattern, String str) {
		if(pattern.length() != str.split("\\s+").length)
			return false;
		Map<String, String> map = new HashMap<>();
		Map<String, String> revMap = new HashMap<>();
		
		int n = pattern.length();
		String[] words = str.split("\\s+");
		
		for(int i = 0; i < n; i++) {
			String str1 = pattern.charAt(i) + "";
			String str2 = words[i];
			if(!map.containsKey(str1)) {
				if(!revMap.containsKey(str2)) {
					map.put(str1, str2);
					revMap.put(str2, str1);
				} else {
					return false;
				}
			} else {
				String val = map.get(str1);
				if(!val.equals(str2))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog cat cat dog";
		
		boolean ans = wordPattern(pattern, str);
		
		System.out.println(ans);
		
		pattern = "abba";
		str = "dog cat cat fish";
		
		ans = wordPattern(pattern, str);
		
		System.out.println(ans);
		
		pattern = "aaaa";
		str = "dog cat cat dog";
		
		ans = wordPattern(pattern, str);
		
		System.out.println(ans);
		
		pattern = "abba";
		str = "dog dog dog dog";
		
		ans = wordPattern(pattern, str);
		
		System.out.println(ans);

	}

}
