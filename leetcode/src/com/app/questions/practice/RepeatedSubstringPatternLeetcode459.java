package com.app.questions.practice;

public class RepeatedSubstringPatternLeetcode459 {
	private static boolean canBeFormed(String s, String substring, int n) {
		if (n % substring.length() != 0)
			return false;
		int nTimes = n / substring.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nTimes; i++) {
			sb.append(substring);
		}
		return sb.toString().equals(s);
	}

	private static boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		int i = 0;
		String substring = null;
		while (i < n) {
			int j = i + 1;
			while (j < n && s.charAt(i) != s.charAt(j)) {
				j++;
			}

			int len = (j - i);

			if (j + len > n)
				return false;
			String str1 = s.substring(i, len);
			String str2 = s.substring(j, j + len);
			if (str1.equals(str2)) {
				substring = str1;
				if (canBeFormed(s, substring, n))
					return true;
				else
					j++;

			} else {
				j++;
			}
			if(j == n)
				return false;
			i++;
		}
		return canBeFormed(s, substring, n);
	}

	public static void main(String[] args) {
		String str = "abab";
		
		boolean isPossible = repeatedSubstringPattern(str);
		
		System.out.println(isPossible);
		
		str = "aba";
		
		isPossible = repeatedSubstringPattern(str);
		
		System.out.println(isPossible);
		
		str = "abcabcabcabc";
		
		isPossible = repeatedSubstringPattern(str);
		
		System.out.println(isPossible);
	}

}
