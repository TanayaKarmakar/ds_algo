package com.app.questions;

public class PaintFenceLeetcode276 {
	private static int numWays(int n, int k) {
		if (n == 0 || k == 0)
			return 0;
		if (n == 1)
			return k;
		int[] dp = new int[n + 1];
		int same = 0;
		int diff = k;
		dp[0] = 0;
		dp[1] = k;
		for (int i = 2; i <= n; i++) {
			same = diff;
			diff = dp[i - 1] * (k - 1);
			dp[i] = same + diff;
		}

		return dp[n];
	}

	public static void main(String[] args) {
		int numWays = numWays(3, 2);

		System.out.println(numWays);

	}

}
