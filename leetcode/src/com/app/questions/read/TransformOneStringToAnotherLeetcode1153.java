package com.app.questions.read;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransformOneStringToAnotherLeetcode1153 {
	private static boolean canConvert(String str1, String str2) {
		int n = str1.length();
		
		Map<Character, Character> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			if(map.containsKey(str1.charAt(i)) 
					&& map.get(str1.charAt(i)) != str2.charAt(i)) {
				return false;
			}
			map.put(str1.charAt(i), str2.charAt(i));
			set.add(str2.charAt(i));
		}
		
		if(str1.equals(str2) == false && map.size() == 26 
				&& set.size() == 26)
			return false;
		return true;
	}

	public static void main(String[] args) {
		String str1 = "aabcc";
		String str2 = "ccdee";
		
		System.out.println(canConvert(str1, str2));
		
		str1 = "leetcode";
		str2 = "codeleet";
		
		System.out.println(canConvert(str1, str2));

	}

}
