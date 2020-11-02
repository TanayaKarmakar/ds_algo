package com.app.practice.bitmagic;

import java.util.Scanner;

public class NumberOfSetBitsLeetcode191 {
	private static int hammingWeight(int n) {
		int count = 0;
		while(n != 0) {
			count++;
			n = (n & (n - 1));
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int ans = hammingWeight(n);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
