package com.app.practice.array;

import java.util.Scanner;

public class DetectCapitalLeetcode520 {
	private static boolean detectCapitalUse(String word) {
		int n = word.length();
		
		boolean[] cap = new boolean[n];
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(word.charAt(i) >= 65 && word.charAt(i) <= 91) {
				cap[i] = true;
				count++;
			}
		}
		
		if(count == 0 || count == n)
			return true;
		if(count == 1) {
			if(cap[0] == true)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.next();
		
		boolean ans = detectCapitalUse(txt);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
