package com.app.dynamicprogramming.classroom;

public class MaximumCutDP {
	private static int getMaxCut(int n, int a, int b, int c) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = -1;
			if (i - a >= 0)
				dp[i] = Integer.max(dp[i], dp[i - a]);
			if (i - b >= 0)
				dp[i] = Integer.max(dp[i], dp[i - b]);
			if (i - c >= 0)
				dp[i] = Integer.max(dp[i], dp[i - c]);

			if (dp[i] != -1)
				dp[i]++;
		}

		return dp[n];
	}

	public static void main(String[] args) {
		int n = 23;
		int a = 12;
		int b = 11;
		int c = 13;

		int maxCut = getMaxCut(n, a, b, c);

		System.out.println("MaxCut - " + maxCut);

	}

}
