package com.app.dynamicprogramming;

import java.util.Scanner;

public class PerfectSquares {
	private static int minSquares(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			int subRes = Integer.MAX_VALUE;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				subRes = Integer.min(subRes, dp[i - (j * j)]);
			}
			dp[i] = 1 + subRes;
		}

		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int ans = minSquares(n);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
