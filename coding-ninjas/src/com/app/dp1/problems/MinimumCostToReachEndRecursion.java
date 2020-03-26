package com.app.dp1.problems;

public class MinimumCostToReachEndRecursion {
	private static int minCost(int[][] steps, int si, int sj, int ei, int ej) {
		if (si == ei && sj == ej)
			return steps[ei][ej];
		if (si > ei || sj > ej) {
			return Integer.MAX_VALUE;
		}
		int option1 = minCost(steps, si + 1, sj, ei, ej);
		int option2 = minCost(steps, si + 1, sj + 1, ei, ej);
		int option3 = minCost(steps, si, sj + 1, ei, ej);

		return steps[si][sj] + Integer.min(option1, Integer.min(option2, option3));
	}

	public static void main(String[] args) {
		int[][] steps = { { 4, 3, 2 }, { 1, 8, 3 }, { 1, 1, 8 } };
		int minCost = minCost(steps, 0, 0, 2, 2);
		
		System.out.println("MinCost - " + minCost);

	}

}
