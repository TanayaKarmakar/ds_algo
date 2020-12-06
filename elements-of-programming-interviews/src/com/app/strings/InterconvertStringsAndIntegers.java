package com.app.strings;

import java.util.Scanner;

public class InterconvertStringsAndIntegers {
	private static int convertStringToIntegers(String s) {
		int n = s.length();
		int start = 0;
		boolean isNeg = false;
		if (s.charAt(0) == '+' || s.charAt(0) == '-') {
			if (s.charAt(0) == '-')
				isNeg = true;
			start = 1;
		}

		long result = 0;
		for (int i = start; i < n; i++) {
			int val = s.charAt(i) - '0';
			result = result * 10 + val;
			if (result >= Integer.MAX_VALUE) {
				result = Integer.MAX_VALUE;
				break;
			}
		}

		if (isNeg) {
			if (result == Integer.MAX_VALUE)
				result = Integer.MIN_VALUE;
			else
				result = -result;
		}

		return (int) result;
	}
	
	private static String convertIntegerToString(int number) {
		boolean isNeg = false;
		if(number < 0)
			isNeg = true;
		
		StringBuilder sb = new StringBuilder();
		number = Math.abs(number);
		
		while(number != 0) {
			int r = number % 10;
			sb.insert(0, String.valueOf(r));
			number = number / 10;
		}
		
		if(isNeg) {
			sb.insert(0, "-");
		} else 
			sb.insert(0, "+");
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String numStr = scanner.next();
		int res = convertStringToIntegers(numStr);
		
		System.out.println(res);
		
		String str = convertIntegerToString(res);
		
		System.out.println(str);
		
		scanner.close();

	}

}
