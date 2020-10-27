package com.app.practice.math;

import java.util.Scanner;

public class ArrangingCoinsLeetcode441 {
	private static int arrangeCoins(int n) {
		int j = 1;
		int count = 0;
		while(n >= j) {
			n = n - j;
			j++;
			count++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int ans = arrangeCoins(n);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
