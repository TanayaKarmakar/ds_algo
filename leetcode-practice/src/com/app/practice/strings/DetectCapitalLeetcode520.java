package com.app.practice.strings;

import java.util.Scanner;

public class DetectCapitalLeetcode520 {
	private static boolean detectCapitalUse(String word) {
		int numCaps = 0;
		int n = word.length();
		for(int i = 0; i < n; i++) {
			int asciiValue = word.charAt(i);
			if(asciiValue >= 65 && asciiValue <= 91)
				numCaps++;
		}
		
		if(numCaps == 0 || numCaps == n)
			return true;
		else if(numCaps == 1) {
			if(word.charAt(0) >= 65 && word.charAt(0) <= 91)
				return true;
			else
				return false;
		} else
			return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		System.out.println(detectCapitalUse(str));
		
		scanner.close();

	}

}
