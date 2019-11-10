package com.app.recursion.classroom;

public class CheckPalindrome {
	private static boolean isPalindrome(String str, int start, int end) {
		if((start == end) || (start > end))
			return true;
		if(str.charAt(start) != str.charAt(end))
			return false;
		return isPalindrome(str, ++start, --end);
	}

	public static void main(String[] args) {
		System.out.println("Palindrome - " + isPalindrome("madam", 0, "madam".length() - 1));
		System.out.println("Palindrome - " + isPalindrome("geeks", 0, "geeks".length() - 1));
		System.out.println("Palindrome - " + isPalindrome("123321", 0, "123321".length() - 1));
	}

}
