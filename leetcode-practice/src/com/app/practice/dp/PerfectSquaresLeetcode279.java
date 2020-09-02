package com.app.practice.dp;

import java.util.Arrays;

public class PerfectSquaresLeetcode279 {
	private static final int INT_MAX = 1000000006;

	private static int numSquaresMemo(Integer[][] memo, int n, int i) {
		if (n < 0 || i == 0)
			return INT_MAX;
		if (n == 0)
			return 0;
		if (memo[n][i] == null) {
			int option1 = 1 + numSquaresMemo(memo, n - (i * i), i);
			int option2 = numSquaresMemo(memo, n, (i - 1));
			memo[n][i] = Integer.min(option1, option2);
		}
		return memo[n][i];
	}

	private static int numSquares(int n) {
		int maxBoundary = (int) Math.sqrt(n);
		Integer[][] memo = new Integer[n + 1][maxBoundary + 1];
		int num = numSquaresMemo(memo, n, maxBoundary);
		System.out.println(Arrays.deepToString(memo));
		return num;
	}
	
	private static int numSquares1(int n) {
		int[] dp = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			dp[i] = i;
			for(int j = 1; (i - (j * j)) >=0; j++) {
				dp[i] = Integer.min(1 + dp[i - (j * j)], dp[i]);
			}
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 12;
		
		System.out.println(numSquares1(n));
	}

}
