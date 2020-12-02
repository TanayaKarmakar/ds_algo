package com.app.practice.greedy;

public class GasStationLeetcode134 {
	private static int canCompleteCircuit(int[] gas, int[] cost) {
		int tank = 0;
		int total = 0;
		int start = 0;
		int n = gas.length;

		for (int i = 0; i < n; i++) {
			int consume = gas[i] - cost[i];
			tank += consume;

			if (tank < 0) {
				start = i + 1;
				tank = 0;
			}

			total += consume;
		}

		return total < 0 ? -1 : start;
	}

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		
		int ans = canCompleteCircuit(gas, cost);
		
		System.out.println(ans);
	}

}
