package com.app.problems.gfg.dp.sample;

import java.util.Scanner;

public class PrintFibonacciInReverseOrder {
	private static void printReverse(int n) {
		int[] dp = new int[n + 1];
		dp[n] = 0;
		dp[n - 1] = 1;
		for(int i = n - 2; i >= 0; i--) {
			dp[i] = dp[i + 1] + dp[i + 2];
		}
		
		for(int i = 0; i <= n; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		printReverse(n);
		
		scanner.close();

	}

}
