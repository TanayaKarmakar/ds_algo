package com.app.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithAtMost2DistinctCharsLeetcode159 {
	private static int lengthOfLongestSubstringTwoDistinct(String s) {
		int n = s.length();
		int l = 0;
		int r = 0;

		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;

		while (r < n) {
			char ch = s.charAt(r);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			while (l <= r && map.size() > 2) {
				if (maxLen < (r - l)) {
					maxLen = (r - l);
				}

				char ch1 = s.charAt(l);
				int value = map.get(ch1);
				if (value == 1)
					map.remove(ch1);
				else
					map.put(ch1, --value);
				l++;
			}
			r++;
		}

		if (map.size() <= 2) {
			maxLen = Integer.max(maxLen, (r - l));
		}
		return maxLen;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String txt = scanner.nextLine();
		
		int ans = lengthOfLongestSubstringTwoDistinct(txt);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
