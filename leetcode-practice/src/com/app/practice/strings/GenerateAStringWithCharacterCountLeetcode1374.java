package com.app.practice.strings;

import java.util.Scanner;

public class GenerateAStringWithCharacterCountLeetcode1374 {
	private static String generateTheString(int n) {
		char[] chars = new char[n];
		for(int i = 0; i < n; i++) {
			chars[i] = 'a';
		}
		
		if(n % 2 == 0) {
			chars[n - 1] = 'b';
		}
		
		return new String(chars);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		String ans = generateTheString(n);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
