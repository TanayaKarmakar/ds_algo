package com.app.practice;

import java.util.Arrays;

public class TwoCitySchedulingCostLeetcode1029 {
	private static int tcsc(int[][] memo, int[][] costs, int iA, int iB, int indx) {
		if (indx == costs.length && iA == 0 && iB == 0)
			return 0;
		if (memo[iA][iB] == -1) {
			int minCost = Integer.MAX_VALUE;
			if (iA > 0) {
				minCost = tcsc(memo, costs, iA - 1, iB, indx + 1) + costs[indx][0];
			}
			if (iB > 0) {
				minCost = Integer.min(minCost, tcsc(memo, costs, iA, iB - 1, indx + 1) + costs[indx][1]);
			}
			memo[iA][iB] = minCost;
		}
		return memo[iA][iB];
	}

	private static int twoCitySchedCost(int[][] costs) {
		int n = costs.length;
		int[][] memo = new int[n / 2 + 1][n / 2 + 1];
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		return tcsc(memo, costs, n / 2, n / 2, 0);
	}

	public static void main(String[] args) {
		int[][] costs = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
		int cost = twoCitySchedCost(costs);
		
		System.out.println(cost);
	}

}
