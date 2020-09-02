package com.app.practice.greedy;

import java.util.Arrays;

public class TwoCitySchedulingCostLeetcode1029 {
	private static int twoCitySchedCost(int[][] costs) {
		int n = costs.length;
		int[][] diff = new int[n][3];

		for (int i = 0; i < n; i++) {
			diff[i][0] = costs[i][0];
			diff[i][1] = costs[i][1];
			diff[i][2] = costs[i][0] - costs[i][1];
		}

		Arrays.sort(diff, (e1, e2) -> e1[2] - e2[2]);

		int totalCost = 0;

		for (int i = 0; i < n / 2; i++) {
			totalCost += diff[i][0];
		}

		for (int i = n / 2; i < n; i++) {
			totalCost += diff[i][1];
		}

		return totalCost;
	}

	public static void main(String[] args) {
		int[][] costs = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
	
		int totalCost = twoCitySchedCost(costs);
		
		System.out.println("TotalCost - " + totalCost);
	}

}
