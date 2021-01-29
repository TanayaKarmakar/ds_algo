package com.app.practice.math;

public class PalindromeNumberLeetCode9 {
	private static boolean isPalindrome(int x) {
		if(x < 0 || x == Integer.MAX_VALUE || x == Integer.MIN_VALUE)
			return false;
		int temp = x;
		long sum = 0;
		while(temp > 0) {
			int r = temp % 10;
			sum = sum * 10 + r;
			
			if(sum >= Integer.MAX_VALUE)
				return false;
			temp = temp / 10;
		}
		
		return x == (int)sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
