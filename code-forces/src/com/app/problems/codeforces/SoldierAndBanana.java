package com.app.problems.codeforces;

import java.util.Scanner;

public class SoldierAndBanana {
	private static int calcAmount(int k, int n, int w) {
		int totalAmount = 0;
		int i = 1;
		while(i <= w) {
			totalAmount += (i * k);
			i++;
		}
		
		if(totalAmount > n)
			return (totalAmount - n);
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int k = scanner.nextInt();
		int n = scanner.nextInt();
		int w = scanner.nextInt();

		int amount = calcAmount(k, n, w);
		
		System.out.println(amount);
		
		scanner.close();
	}

}
