package com.app.questions;

public class BalanceStringSplit {
	private static int balancedStringSplit(String s) {
		int n = s.length();
		int res = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {
			if(s.charAt(i) == 'L')
				count++;
			else
				count--;
			if(count == 0)
				res++;
		}
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println("Count - " + balancedStringSplit("RLRRLLRLRL"));

	}

}
