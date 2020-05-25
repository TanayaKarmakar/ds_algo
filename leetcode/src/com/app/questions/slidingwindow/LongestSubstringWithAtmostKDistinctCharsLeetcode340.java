package com.app.questions.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKDistinctCharsLeetcode340 {
	private static int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s.length() < k)
			return s.length();
		int n = s.length();
		int l = 0;
		int r = 0;
		int maxLen = 0;

		Map<Character, Integer> map = new HashMap<>();

		while (r < n) {
			char ch = s.charAt(r);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			while (l <= r && map.size() > k) {
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
		if (map.size() <= k) {
			if (maxLen < (r - l))
				maxLen = (r - l);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String str = "eceba";

		int maxLen = lengthOfLongestSubstringKDistinct(str, 2);

		System.out.println(maxLen);

		str = "ccaabbb";

		maxLen = lengthOfLongestSubstringKDistinct(str, 3);

		System.out.println(maxLen);
	}

}
