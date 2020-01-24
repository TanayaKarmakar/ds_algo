package com.app.questions;

public class PalindromeNumber {
	private static boolean isPalindromeEfficient(int x) {
		if(x < 0)
			return false;
		
		int res = 0;
		int tmp = x;
		while(tmp > res) {
			int r = tmp % 10;
			res = res * 10 + r;
			tmp = tmp / 10;
		}
		
		return tmp == res || tmp == res  / 10;
	}
	
	private static boolean isPalindrome1(int x) {
		int tmp = Math.abs(x);
		
		int res = 0;
		while(tmp != 0) {
			int r = tmp % 10;
			res = res * 10 + r;
			tmp = tmp / 10;
		}
		
		return res == x;
	}
	
	private static boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		String str = String.valueOf(Math.abs(x));
		
		int n = str.length();
		
		int start = 0;
		int end = n - 1;
		while(start <= end) {
			if(str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		int x = 121;
		
		System.out.println("Is Palindrome - " + isPalindrome(x));
		System.out.println("Is Palindrome Efficient - " + isPalindromeEfficient(x));
		
		x = 123;
		System.out.println("Is Palindrome - " + isPalindrome(x));
		System.out.println("Is Palindrome Efficient - " + isPalindromeEfficient(x));
		
		x = -123321;
		System.out.println("Is Palindrome - " + isPalindrome(x));
		System.out.println("Is Palindrome Efficient - " + isPalindromeEfficient(x));

	}

}
