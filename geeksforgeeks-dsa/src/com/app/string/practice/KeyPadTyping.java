package com.app.string.practice;

import java.util.Scanner;

public class KeyPadTyping {
	private static String getDecimal(String str) {
		// char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int[] numbers = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 
				6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int indx = str.charAt(i) - 'a';
			sb.append(numbers[indx]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
//		String str = "geeksforgeeks";
//		System.out.println(getDecimal(str));
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		StringBuilder sb = new StringBuilder();
		while(nTestCases > 0) {
		    String str = scanner.next();
		    sb.append(getDecimal(str) + "\n");
		    nTestCases--;
		}
		
		System.out.print(sb.toString());
		scanner.close();
		
	}

}
