package com.app.practice.dp;

import java.util.Scanner;

public class PerfectSquaresLeetcode279 {
	private static int numSquares(int n) {
		int[] dp = new int[n + 1];
		int sqrt = (int) Math.sqrt(n);

		for (int i = 1; i <= n; i++) {
			dp[i] = i;
			int subRes = i;
			for (int j = 0; j <= sqrt; j++) {
				if (i >= (j * j)) {
					subRes = Integer.min(subRes, dp[i - (j * j)]);
				}
			}
			if (subRes != i)
				dp[i] = Integer.min(subRes + 1, dp[i]);
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int ans = numSquares(n);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
