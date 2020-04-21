package com.app.questions.practice;

public class LongestPalindromicSubstringLeetcode5 {
	private static String lps(String s) {
		int n = s.length();
		
		int maxLen = 1;
		int start = 0;
		
		int low = 0;
		int high = 0;
		
		for(int i = 1; i < n; i++) {
			
			//even length
			low = i - 1;
			high = i + 1;
			while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
				if(maxLen < (high - low + 1)) {
					start = low;
					maxLen = (high - low + 1);
				}
				low--;
				high++;
			}
			
			//odd length
			low = i - 1;
			high = i;
			while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
				if(maxLen < (high - low + 1)) {
					start = low;
					maxLen = (high - low + 1);
				}
				low--;
				high++;
			}
		}
		
		int end = start + maxLen - 1;
		return s.substring(start, end + 1);
	}

	public static void main(String[] args) {
//		String str = "babad";
//		
//		System.out.println(lps(str));
//		
//		str = "ac";
		
		System.out.println(lps("ac"));

	}

}
