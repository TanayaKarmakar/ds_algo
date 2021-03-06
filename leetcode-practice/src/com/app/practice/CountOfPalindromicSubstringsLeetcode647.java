package com.app.practice;

public class CountOfPalindromicSubstringsLeetcode647 {
	private static int countSubstrings(String s) {
		int n = s.length();
		int count = 0;
		
		int i = 0;
		while(i < n) {
			int left = i;
			int right = i;
			while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				count++;
				left--;
				right++;
			}
			
			left = i - 1;
			right = i;
			
			while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				count++;
				left--;
				right++;
			}
			i++;
		}
		return count;
	}

	public static void main(String[] args) {
		String str = "abc";
		
		int count = countSubstrings(str);
		
		System.out.println(count);
		
		str = "aaa";
		
		count = countSubstrings(str);
		
		System.out.println(count);

	}

}
