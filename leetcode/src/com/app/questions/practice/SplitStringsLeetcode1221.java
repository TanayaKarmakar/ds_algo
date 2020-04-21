package com.app.questions.practice;

public class SplitStringsLeetcode1221 {
	private static int balancedSplitStrings(String s) {
		int n = s.length();
		int totalCount = 0;
		int currentCount = 0;
		
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == 'R')
				currentCount++;
			else
				currentCount--;
			if(currentCount == 0)
				totalCount++;
		}
		return totalCount;
	}

	public static void main(String[] args) {
		String s = "RLRRLLRLRL";
		
		System.out.println(balancedSplitStrings(s));
		
		s = "RLLLLRRRLR";
		
		System.out.println(balancedSplitStrings(s));
		
		s = "LLLLRRRR";
		
		System.out.println(balancedSplitStrings(s));
		
		s = "RLRRRLLRLL";
		
		System.out.println(balancedSplitStrings(s));
	}

}
