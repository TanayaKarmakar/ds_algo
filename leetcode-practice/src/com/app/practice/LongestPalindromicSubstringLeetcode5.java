package com.app.practice;

public class LongestPalindromicSubstringLeetcode5 {
	private static String longestPalindrome(String s) {
		if(s.length() <= 1)
			return s;
		int n = s.length();
		int start = 0;
		int end = 0;
		int maxLen = 1;
		
		for(int i = 1; i < n; i++) {
			int low = i - 1;
			int high = i + 1;
			while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
				if(maxLen < high - low + 1) {
					maxLen = high - low + 1;
					start = low;
				}
				low--;
				high++;
			}
			
			low = i - 1;
			high = i;
			while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
				if(maxLen < high - low + 1) {
					maxLen = high - low + 1;
					start = low;
				}
				low--;
				high++;
			}
		}
		end = start + maxLen;
		return s.substring(start, end);
	}

	public static void main(String[] args) {
		String str = "babad";
		
		System.out.println(longestPalindrome(str));
		
		str = "cbbd";
		
		System.out.println(longestPalindrome(str));

	}

}
