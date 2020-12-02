package com.app.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class PerfectSquaresLeetcode279 {
	private static int numSquares(int n) {
		int[] dp = new int[n + 1];

		Arrays.fill(dp, n);
		
		dp[0] = 0;
		
		int end = (int)Math.sqrt(n);

		for (int i = 1; i <= n; i++) {
			int subRes = i;
			dp[i] = i;
			for (int j = 0; j <= end; j++) {
				if ((i - j * j) >= 0) {
					subRes = Integer.min(subRes, dp[i - (j * j)]);
				}
			}

			if (subRes != i) {
				dp[i] = Integer.min(dp[i], subRes + 1);
			}
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
