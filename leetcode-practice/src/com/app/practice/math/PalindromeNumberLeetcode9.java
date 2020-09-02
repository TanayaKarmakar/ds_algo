package com.app.practice.math;

import java.util.Scanner;

public class PalindromeNumberLeetcode9 {
	private static boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		int sum = 0;
		int tmp = x;
		while(tmp != 0) {
			int r = tmp % 10;
			sum = sum * 10 + r;
			if(sum == (Integer.MAX_VALUE) / 10)
				return false;
			tmp = tmp / 10;
		}
		
		if(sum == x)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		System.out.println(isPalindrome(num));
		
		scanner.close();
	}

}
