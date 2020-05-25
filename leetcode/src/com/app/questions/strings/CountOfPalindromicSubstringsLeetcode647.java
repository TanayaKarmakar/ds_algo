package com.app.questions.strings;

public class CountOfPalindromicSubstringsLeetcode647 {
	private static int countSubstrings(String S) {
		int n = S.length();

		int count = 0;
		int i = 0;
		while (i < n) {
			int left = i;
			int right = i;
			while (left >= 0 && right < n && S.charAt(left) == S.charAt(right)) {
				count++;
				left--;
				right++;
			}

			left = i - 1;
			right = i;

			while (left >= 0 && right < n && S.charAt(left) == S.charAt(right)) {
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

		System.out.println(countSubstrings(str));

		str = "aaa";

		System.out.println(countSubstrings(str));

	}

}
