package com.app.dp1.problems;

public class StairCaseProblem {
	private static int numWays(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		return dp[n];
	}

	public static void main(String[] args) {
		int n = 4;
		
		System.out.println(numWays(70));
	}

}
