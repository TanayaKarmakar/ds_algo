package com.app.strings;

public class TestPalindromicity {
	private static boolean isPalindrome(String str) {
		str = str.toLowerCase();
		str = str.replaceAll("[^a-z0-9]", "");

		int start = 0;
		int end = str.length() - 1;
		while (start < end) {
			if (str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}

		return true;
	}

	public static void main(String[] args) {
		String str = "Able was I, ere I saw Elba";
		
		System.out.println(isPalindrome(str));
		
		str = "Ray I Ray";
		
		System.out.println(isPalindrome(str));

	}

}
