package com.app.questions;

public class ValidPalindrome {
	private static boolean isValidChar(char ch) {
		if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
			return true;
		else
			return false;
	}
	private static boolean isValidEfficient(String str) {
		int start = 0;
		int end = str.length() - 1;
		str = str.toLowerCase();
		while(start < end) {
			if(isValidChar(str.charAt(start))) {
				if(isValidChar(str.charAt(end))) {
					if(str.charAt(start) != str.charAt(end)) {
						return false;
					} else {
						start++;
						end--;
					}
				} else {
					end--;
				}
			} else {
				start++;
			}
		}
		return true;
	}
	
	private static boolean isValid(String str) {
		if(str.isEmpty() || str.trim().isEmpty())
			return true;
		str = str.toLowerCase();
		str = str.replaceAll("[^a-zA-Z0-9]", "");
		str = str.replaceAll("\\s+", "");
		
		char[] chars = str.toCharArray();
		int start = 0;
		int end = chars.length - 1;
		while(start <= end) {
			if(chars[start] != chars[end])
				return false;
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		System.out.println(isValidEfficient(str));
		
		str = "race a car";
		System.out.println(isValidEfficient(str));
	}

}
