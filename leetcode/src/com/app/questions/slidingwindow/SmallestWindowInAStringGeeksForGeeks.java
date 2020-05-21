package com.app.questions.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmallestWindowInAStringGeeksForGeeks {
	private static String smallestWindow(String str, String pattern) {
		Map<Character, Integer> pattMap = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			pattMap.put(ch, pattMap.getOrDefault(ch, 0) + 1);
		}

		int l = 0;
		int r = 0;
		int left = 0;
		int right = 0;
		int maxLen = -1;
		int n = str.length();
		int required = pattMap.size();

		int formed = 0;

		Map<Character, Integer> strMap = new HashMap<>();
		while (r < n) {

			char ch = str.charAt(r);
			strMap.put(ch, strMap.getOrDefault(ch, 0) + 1);
			if (pattMap.containsKey(ch) && strMap.get(ch) == pattMap.get(ch)) {
				formed++;
			}

			while (l <= r && formed == required) {
				if (maxLen == -1 || maxLen > (r - l + 1)) {
					maxLen = (r - l + 1);
					left = l;
					right = r;
				}
				ch = str.charAt(l);
				int val = strMap.get(ch);
				strMap.put(ch, --val);
				
				if (pattMap.containsKey(ch) && strMap.get(ch) < pattMap.get(ch))
					formed--;
				
				
				l++;	
			}
			r++;
		}
		return maxLen == -1 ? "" : str.substring(left, right + 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();

		while (nTestCases-- > 0) {
			String str = scanner.next();
			String pattern = scanner.next();
			System.out.println(smallestWindow(str, pattern));
		}
		scanner.close();
	}

}
