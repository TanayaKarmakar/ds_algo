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
	
	/*private static String minWindow(String s, String t) {
		Set<Character> tSet = new HashSet<>();
		int n = t.length();
		for(int i = 0; i < n; i++) {
			tSet.add(t.charAt(i));
		}
		
		Map<Character, Integer> sMap = new HashMap<>();
		int m = s.length();
		int i = 0;
		int start = 0;
		int minLen = Integer.MAX_VALUE;
		String ans = "";
		while(i < m) {
			if(tSet.contains(s.charAt(i))) {
				sMap.put(s.charAt(i), 
						sMap.getOrDefault(s.charAt(i), 0) + 1);
				while(tSet.size() == sMap.size()) {
					if(minLen > (i - start) + 1) {
						minLen = Integer.min(minLen, (i - start) + 1);
						ans = s.substring(start, start + minLen);
					}
					
					char ch = s.charAt(start);
					if(sMap.containsKey(ch)) {
						if(sMap.get(ch) == 1) {
							sMap.clear();
							start = i + 1;
						} else {
							int val = sMap.get(ch);
							sMap.put(ch, --val);	
						}
					}
					
					start++;
				}
			}
			i++;
			//start = i;
		}
		return ans;
	}*/

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		
		String ans = minWindow(s, t);
		
		System.out.println(ans);
		
		s = "aa";
		t = "a";
		
		ans = minWindow(s, t);
		
		System.out.println(ans);

	}

}
