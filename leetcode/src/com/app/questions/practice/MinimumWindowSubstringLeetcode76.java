package com.app.questions.practice;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringLeetcode76 {
	private static String minWindow(String s, String t) {
		Map<Character, Integer> tMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
		}

		int left = 0;
		int right = 0;
		int diff = Integer.MAX_VALUE;

		int l = 0;
		int r = 0;

		int required = tMap.size();
		int formed = 0;
		Map<Character, Integer> sMap = new HashMap<>();
		while (r < s.length()) {
			char ch = s.charAt(r);
			sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

			if (tMap.containsKey(ch) && sMap.get(ch) == tMap.get(ch))
				formed++;

			while (l <= r && formed == required) {
				if (r - l + 1 < diff) {
					diff = r - l + 1;
					left = l;
					right = r;
				}
				char ch1 = s.charAt(l);
				int val = sMap.get(ch1);
				sMap.put(ch1, --val);

				if (tMap.containsKey(ch1) && sMap.get(ch1) < tMap.get(ch1)) {
					formed--;
				}
				
				l++;
			}
			r++;
		}
		return diff == -1 ? "" :s.substring(left, right + 1);
	}

	public static void main(String[] args) {
		String s = "aa";
		String t = "a";

		System.out.println(minWindow(s, t));

	}

}
