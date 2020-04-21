package com.app.questions.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatinhCharactersLeetcode3 {
	private static int length(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int ans = 0;
		int n = s.length();
		int i = 0;
		int j = 0;
		for(i = 0, j = 0; j < n; j++) {
			if(map.containsKey(s.charAt(j))) {
				i = Integer.max(map.get(s.charAt(j)), i);
			}
			ans = Integer.max(ans, (j - i) + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		String str = "abcabcbb";
		
		int ans = length(str);
		
		System.out.println(ans);

	}

}
