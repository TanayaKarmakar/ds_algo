package com.app.practice.greedy;

import java.util.Arrays;

public class TwoCitySchedulingLeetcode1029 {
	private static int twoCitySchedCost(int[][] costs) {
		int n = costs.length;
		int[][] diffArr = new int[n][3];

		for (int i = 0; i < n; i++) {
			int diff = costs[i][0] - costs[i][1];
			diffArr[i] = new int[3];
			diffArr[i][0] = costs[i][0];
			diffArr[i][1] = costs[i][1];
			diffArr[i][2] = diff;
		}

		Arrays.sort(diffArr, (e1, e2) -> (e1[2] - e2[2]));

		int total = 0;
		for (int i = 0; i < n / 2; i++) {
			total += diffArr[i][0];
		}

		for (int i = n / 2; i < n; i++) {
			total += diffArr[i][1];
		}

		return total;
	}

	public static void main(String[] args) {
		int[][] costs = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
		int total = twoCitySchedCost(costs);
		
		System.out.println(total);
	}

}
