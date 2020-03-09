package com.app.questions;

public class AddDigitsLeetcode258 {
	private static int addDigits(int num) {
		if(num == 0)
			return 0;
		return (num % 9) == 0? 0 : (num % 9);
	}

	public static void main(String[] args) {
		int num = 38;
		
		System.out.println("AddDigit - " + addDigits(num));

	}

}
