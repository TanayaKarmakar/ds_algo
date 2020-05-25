package com.app.questions.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmost2DistinctCharsLeetcode159 {
	private static int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s.length() < 2)
			return s.length();
		int n = s.length();
		int l = 0;
		int r = 0;
		int maxLen = 0;

		Map<Character, Integer> map = new HashMap<>();

		while (r < n) {
			char ch = s.charAt(r);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			while (l <= r && map.size() > 2) {
				if (maxLen < (r - l))
					maxLen = r - l;
				ch = s.charAt(l);
				int val = map.get(ch);
				if (val == 1) {
					map.remove(ch);
				} else {
					map.put(ch, --val);
				}
				l++;
			}
			r++;
		}
		if(map.size() <= 2) {
			if(maxLen < (r - l))
				maxLen = (r - l);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String str = "eceba";

		int maxLen = lengthOfLongestSubstringTwoDistinct(str);

		System.out.println(maxLen);

		str = "ccaabbb";

		maxLen = lengthOfLongestSubstringTwoDistinct(str);

		System.out.println(maxLen);

	}

}
