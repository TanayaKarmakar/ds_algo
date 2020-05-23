package com.app.questions.read;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringLeetcode76 {
	private static String minWindow(String s, String t) {
		if(s.length() == 0 || t.length() == 0)
			return "";
		
		Map<Character, Integer> pattMap = new HashMap<>();
		for(int i = 0; i < t.length(); i++) {
			pattMap.put(t.charAt(i), pattMap.getOrDefault(t.charAt(i), 0) + 1);
		}
		
		int required = pattMap.size();
		
		Map<Character, Integer> sMap = new HashMap<>();
		int l, r;
		l = r = 0;
		
		int n = s.length();
		int len = -1;
		int left = 0;
		int right = 0;
		int formed = 0;
		
		while(r < n) {
			char ch = s.charAt(r);
			sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
			
			if(pattMap.containsKey(ch) && pattMap.get(ch) == sMap.get(ch))
				formed++;
			
			while(l <= r && required == formed) {
				if(len == -1 || len > (r - l + 1)) {
					len = r - l + 1;
					left = l;
					right = r;
				}
				char ch1 = s.charAt(l);
				int val = sMap.get(ch1);
				
				sMap.put(ch1, --val);
				
				if(pattMap.containsKey(ch1) && sMap.get(ch1) < pattMap.get(ch1))
					formed--;
				
				
				
				l++;	
			}
			
			r++;
		}
		return len == -1 ? "" : s.substring(left, right + 1);
	}
	
	

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		
		String ans = minWindow(s, t);
		
		System.out.println(ans);
		
		s = "aa";
		t = "a";
		
		ans = minWindow(s, t);
		
		System.out.println(ans);
		
		s = "timetopractice";
		t = "toc";
		
		ans = minWindow(s, t);
		
		System.out.println(ans);

	}

}
