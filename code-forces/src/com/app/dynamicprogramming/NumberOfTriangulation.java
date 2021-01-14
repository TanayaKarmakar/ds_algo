package com.app.dynamicprogramming;

import java.util.Scanner;

public class NumberOfTriangulation {
	private static int numWays(int n) {
		int[] dp = new int[n - 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= (n - 2); i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += (dp[j] * dp[i - j - 1]);
			}
		}

		return dp[n - 2];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int ans = numWays(n);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
