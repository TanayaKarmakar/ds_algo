package com.app.practice;

public class RepeatedSubstringPatternLeetcode459 {
	private static boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		int[] lps = new int[n];
		
		int j = 0;
		int i = j + 1;
		while(i < n) {
			if(s.charAt(i) == s.charAt(j)) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {
				if(j == 0)
					i++;
				else {
					j = lps[j - 1];
				}
			}
		}
		
		int lastLen = lps[n - 1];
		int prefixLen = n - lastLen;
		if(lastLen == 0)
			return false;
		return lastLen % prefixLen == 0;
	}
	

	public static void main(String[] args) {
		String str = "aba";
		
		System.out.println(repeatedSubstringPattern(str));
		
		str = "abab";
		
		System.out.println(repeatedSubstringPattern(str));

	}

}
