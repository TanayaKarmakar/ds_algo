package com.app.augustchallenge;

import java.util.Scanner;

public class DetectCapital {
	private static boolean isCapital(String word) {
		int n = word.length();
		boolean[] cap = new boolean[n];
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(word.charAt(i) >= 65 && word.charAt(i) <= 91) {
				cap[i] = true;
				count++;
			}		
		}
		
		if((count == 0 || count == n) || (count == 1 && cap[0] == true))
			return true;
		else
			return false;
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String word = scanner.next();
		
		System.out.println(isCapital(word));
		
		scanner.close();

	}

}
