package com.app.dynamicprogramming.classroom;

public class PaintFenceAlgorithm {
	private static int paintFence(int n, int k) {
		int[] dp = new int[n + 1];
		int same = 0;
		int diff = k;
		dp[0] = 0;
		dp[1] = k;
		for(int i = 2; i <= n; i++) {
			same = diff;
			diff = dp[i - 1]*(k - 1);
			dp[i] = same + diff;
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 3;
		int k = 2;
		int numWays = paintFence(n, k);

		System.out.println(numWays);
	}

}
