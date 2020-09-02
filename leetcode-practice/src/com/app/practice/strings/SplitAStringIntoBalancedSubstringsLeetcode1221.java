package com.app.practice.strings;

import java.util.Scanner;

public class SplitAStringIntoBalancedSubstringsLeetcode1221 {
	private static int balancedStringSplit(String s) {
		int n = s.length();
		
		int count = 0;
		int balancedCount = 0;
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == 'L')
				count++;
			else
				count--;
			if(count == 0)
				balancedCount++;
		}
		
		return balancedCount;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		
		int ans = balancedStringSplit(s);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
