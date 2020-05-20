package com.app.questions;

public class RepeatedSubstringLeetcode459 {
	private static boolean canBeFormed(String s, String substring, int n) {
		if(n % substring.length() != 0)
			return false;
		int nTimes = n / substring.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < nTimes; i++) {
			sb.append(substring);
		}
		
		if(sb.toString().equals(s))
			return true;
		else
			return false;
	}
	private static boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		int i = 0;
		int j = i + 1;
		String substring = null;
		while(i < n) {
			while(j < n && s.charAt(i) != s.charAt(j)) {
				j++;
			}
			int len = (j - i);
			if(j + len > n)
				return false;
			String str1 = s.substring(i, len);
			String str2 = s.substring(j, j + len);
			
			if(str1.equals(str2)) {
				substring = str1;
				if(canBeFormed(s, substring, n))
					return true;
				else
					j++;
			} else {
				j++;
			}
			if(j == n)
				return false;
		}
		
		return canBeFormed(s, substring, n);
	}

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("aba"));
		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("abcabcabc"));
		System.out.println(repeatedSubstringPattern("abac"));
		System.out.println(repeatedSubstringPattern("abaababaab"));
	}

}
