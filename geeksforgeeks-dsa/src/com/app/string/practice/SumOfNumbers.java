package com.app.string.practice;

public class SumOfNumbers {
	private static int sum(String str) {
		int res = 0;
		int n = str.length();

		int curr = 0;
		int prev = -1;

		for (int i = 0; i < n; i++) {
			if (Character.isDigit(str.charAt(i))) {
				if (prev == -1) {
					curr = convertDigit(str.charAt(i));
				} else {
					curr = curr * 10 + convertDigit(str.charAt(i));
				}
				prev = i;
			} else {
				if (curr > 0) {
					res += curr;
					curr = 0;
					prev = -1;
				}
			}
		}
		
		if(curr > 0) {
			res += curr;
		}

		return res;
	}

	private static int convertDigit(char ch) {
		return Integer.parseInt(String.valueOf(ch));
	}

	public static void main(String[] args) {
		String str = "1abc23";

		System.out.println("Sum - " + sum(str));
		
		str = "geeks4geeks";
		
		System.out.println("Sum - " + sum(str));
		
		str = "1abc2x30yz67";
		
		System.out.println("Sum - " + sum(str));
		
		str = "123abc";
		
		System.out.println("Sum - " + sum(str));
	}

}
