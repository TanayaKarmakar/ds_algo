package com.app.stringalgo.problems;

public class CountOfPalindromicSubstring {
	private static int count(String s) {
		int n = s.length();
		
		int left = 0;
		int right = 0;
		
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			left = i;
			right = i;
			
			while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
				count++;
			}
			
			left = i - 1;
			right = i;
			while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String str = "aba";
		
		int count = count(str);
		
		System.out.println(count);

	}

}
