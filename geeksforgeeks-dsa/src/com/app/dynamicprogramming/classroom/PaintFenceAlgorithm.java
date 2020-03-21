package com.app.dynamicprogramming.classroom;

public class PaintFenceAlgorithm {
	private static int paintFence(int n, int k) {
		int[] dp = new int[n + 1];

		int same = k;
		int diff = k * (k - 1);

		dp[0] = 0;
		dp[1] = k;
		dp[2] = k * k;

		for (int i = 3; i <= n; i++) {
			dp[i] = (same + diff);
			same = diff;
			diff = dp[i] * (k - 1);
		}

		return dp[n];
	}

	public static void main(String[] args) {
		int n = 2;
		int k = 4;
		int numWays = paintFence(n, k);

		System.out.println(numWays);
	}

}
