package com.app.practice.strings;

import java.util.Scanner;

public class PalindromicSubstringsLeetcode647 {
	private static int countSubstrings(String s) {
		if(s.length() == 0)
			return 0;
		int count = 0;
		int n = s.length();

		for (int i = 0; i < n; i++) {
			int left = i;
			int right = i;

			while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				count++;
				left--;
				right++;
			}

			left = i - 1;
			right = i;

			while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				count++;
				left--;
				right++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String txt = scanner.nextLine();
		
		int ans = countSubstrings(txt);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
