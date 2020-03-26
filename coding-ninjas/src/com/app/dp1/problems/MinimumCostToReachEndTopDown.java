package com.app.dp1.problems;

import java.util.Arrays;

public class MinimumCostToReachEndTopDown {
	private static int minCost(int[][] dp, int[][] steps, int si, int sj, int ei, int ej) {
		if (si == ei && sj == ej)
			return steps[ei][ej];
		if (si > ei || sj > ej)
			return Integer.MAX_VALUE;
		if (dp[si][sj] == -1) {
			int option1 = minCost(dp, steps, si + 1, sj, ei, ej);
			int option2 = minCost(dp, steps, si + 1, sj + 1, ei, ej);
			int option3 = minCost(dp, steps, si, sj + 1, ei, ej);
			dp[si][sj] = steps[si][sj] + Integer.min(option1, Integer.min(option2, option3));
		}
		return dp[si][sj];
	}

	private static int minCost(int[][] steps, int si, int sj, int ei, int ej) {
		int[][] dp = new int[ei + 1][ej + 1];
		for (int i = 0; i <= ei; i++) {
			Arrays.fill(dp[i], -1);
		}

		return minCost(dp, steps, si, sj, ei, ej);
	}

	public static void main(String[] args) {
		int[][] steps = { { 4, 3, 2 }, { 1, 8, 3 }, { 1, 1, 8 } };
		int minCost = minCost(steps, 0, 0, 2, 2);
		
		System.out.println("MinCost - " + minCost);

	}

}
