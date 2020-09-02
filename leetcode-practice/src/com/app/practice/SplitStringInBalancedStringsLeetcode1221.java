package com.app.practice;

public class SplitStringInBalancedStringsLeetcode1221 {
	private static int numBalancedStrings(String s) {
		int n = s.length();
		int count = 0;
		int balancedStringCounter = 0;
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == 'R') {
				balancedStringCounter--;
			} else {
				balancedStringCounter++;
			}
			if(balancedStringCounter == 0) {
				count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		String s = "RLRRLLRLRL";
		
		System.out.println(numBalancedStrings(s));
		
		s = "RLLLLRRRLR";
		
		System.out.println(numBalancedStrings(s));

	}

}
