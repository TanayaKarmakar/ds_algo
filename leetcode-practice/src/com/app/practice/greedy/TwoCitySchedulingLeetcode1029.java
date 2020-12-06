package com.app.practice.greedy;

import java.util.Arrays;

public class TwoCitySchedulingLeetcode1029 {
	private static int twoCitySchedCost(int[][] costs) {
		int n = costs.length;
		int[][] diffArr = new int[costs.length][3];

		for (int i = 0; i < costs.length; i++) {
			int diff = costs[i][0] - costs[i][1];
			diffArr[i][0] = costs[i][0];
			diffArr[i][1] = costs[i][1];
			diffArr[i][2] = diff;
		}

		Arrays.sort(diffArr, (e1, e2) -> e1[2] - e2[2]);

		int totalCost = 0;
		for (int i = 0; i < n / 2; i++) {
			totalCost += diffArr[i][0];
		}

		for (int i = n / 2; i < n; i++) {
			totalCost += diffArr[i][1];
		}

		return totalCost;
	}

	public static void main(String[] args) {
		int[][] costs = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
		int totalCost = twoCitySchedCost(costs);
		
		System.out.println(totalCost);
	}

}
