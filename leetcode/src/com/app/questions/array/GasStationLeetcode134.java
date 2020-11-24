package com.app.questions.array;

public class GasStationLeetcode134 {
	private static int canCompleteCircuit(int[] gas, int[] cost) {
		int tank = 0, total = 0, start = -1;
		for(int i = 0; i < gas.length; i++) {
			int consume = gas[i] - cost[i];
			tank += consume;
			if(tank < 0) {
				start = i + 1;
				tank = 0;
			}
			total += consume;
		}
		
		return total < 0 ? -1: start;
	}

	public static void main(String[] args) {
		int[] gas = { 3, 3, 4 };
		int[] cost = { 3, 4, 4 };

		int ans = canCompleteCircuit(gas, cost);

		System.out.println(ans);

	}

}
