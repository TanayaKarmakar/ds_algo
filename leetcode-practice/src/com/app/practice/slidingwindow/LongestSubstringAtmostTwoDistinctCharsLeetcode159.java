package com.app.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringAtmostTwoDistinctCharsLeetcode159 {
	private static int lengthOfLongestSubstringTwoDistinct(String s) {
		int n = s.length();
		int r = 0;
		int l = 0;
		
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		while(r < n) {
			char ch = s.charAt(r);
			
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			
			while(l <= r && map.size() > 2) {
				if(maxLen < (r - l)) {
					maxLen = (r - l);
				}
				char ch1 = s.charAt(l);
				int val = map.get(ch1);
				if(val == 1)
					map.remove(ch1);
				else
					map.put(ch1, val - 1);
				l++;
			}
			r++;
		}
		
		if(map.size() <= 2) {
			maxLen = Integer.max(maxLen, (r - l));
		}
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String txt = scanner.next();
		
		int maxLen = lengthOfLongestSubstringTwoDistinct(txt);
		
		System.out.println(maxLen);
		
		scanner.close();

	}

}
