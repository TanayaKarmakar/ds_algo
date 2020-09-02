package com.app.practice.bitmagic;

import java.util.Scanner;

public class PowerOfTwoLeetcode231 {
	private static boolean isPowerOfTwo(int n) {
		if(n <= 0)
			return false;
		return (n & (n - 1)) == 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		System.out.println(isPowerOfTwo(n));
		
		scanner.close();

	}

}
