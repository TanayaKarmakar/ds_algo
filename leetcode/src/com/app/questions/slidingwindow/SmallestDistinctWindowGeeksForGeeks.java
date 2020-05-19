package com.app.questions.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SmallestDistinctWindowGeeksForGeeks {
	private static int smallestDistinctWindow(String str) {
		Set<Character> charSet = new HashSet<>();
		int n = str.length();
		for(int i = 0; i < n; i++) {
			charSet.add(str.charAt(i));
		}
		
		int required = charSet.size();
		
		int minLen = str.length();
		int l = 0;
		int r = 0;
		
		Map<Character, Integer> charMap = new HashMap<>();
		while(r < n) {
			while(r < n && charMap.size() < required) {
				charMap.put(str.charAt(r), charMap.getOrDefault(str.charAt(r), 0) + 1);
				r++;
			}
			
			while(l <= r && charMap.size() == required) {
				char ch = str.charAt(l);
				int val = charMap.get(ch);
				if(val == 1)
					charMap.remove(ch);
				else
					charMap.put(ch, --val);
				l++;
			}
			
			if((r - l + 1) < minLen) {
				minLen = r - l + 1;
			}
		}
		return minLen;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			String str = scanner.next();
			int minLen = smallestDistinctWindow(str);
			
			System.out.println(minLen);
			
		}
		scanner.close();
	}

}
