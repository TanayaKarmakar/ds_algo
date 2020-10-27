package com.app.practice.strings;

import java.util.Scanner;

public class SplitStringsIntoBalancedSubstringsLeetcode1221 {
	private static int balancedStringSplit(String s) {
		int totalCount = 0;
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'L')
				count++;
			else
				count--;
			if(count == 0)
				totalCount++;
		}
		
		return totalCount;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		int ans = balancedStringSplit(str);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
