package com.app.stringalgo.problems;

public class LongestPalindromicSubstring {
	private static int longestPalindromicSubstring(String str) {
		int n = str.length();
		
		int maxLen = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		
		for(int i = 1; i < n; i++) {
			int left = i - 1;
			int right = i + 1; 
			while(left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
				if(right - left + 1 > maxLen) {
					maxLen = right - left + 1;
					start = left;
				}
				left--;
				right++;
			}
			left = i - 1;
			right = i;
			while(left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
				if(right - left + 1 > maxLen) {
					maxLen = right - left + 1;
					start = left;
				}
				left--;
				right++;
			}	
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String str = "abbabbabbabbcda";
		
		int maxLen = longestPalindromicSubstring(str);
		
		System.out.println(maxLen);
	}

}
