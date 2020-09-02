package com.app.practice.strings;

import java.util.Scanner;

public class GenerateStringWithOddCharacterCountLeetcode1374 {
	private static String generateString(int n) {
		StringBuilder sb = new StringBuilder();
		if(n % 2 != 0) {
			for(int i = 0; i < n; i++) {
				sb.append("a");
			}
		} else {
			sb.append("a");
			for(int i = 0; i < (n - 1); i++) {
				sb.append("b");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		String ans = generateString(n);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
