package com.app.augustchallenge;

import java.util.HashSet;
import java.util.Set;

public class MinCostForTicket {
	private static int minCostTicket(int[] days, int[] costs) {
		Set<Integer> daysSet = new HashSet<>();

		for (int day : days) {
			daysSet.add(day);
		}

		int lastDay = days[days.length - 1];

		int[] dp = new int[lastDay + 1];

		for (int i = 1; i <= lastDay; i++) {
			if(!daysSet.contains(i)) {
				dp[i] = dp[i - 1];
			} else {
				int day1 = dp[Integer.max(i - 1, 0)] + costs[0];
				int day7 = dp[Integer.max(i - 7, 0)] + costs[1];
				int day30 = dp[Integer.max(i - 30, 0)] + costs[2];

				dp[i] = Integer.min(day1, Integer.min(day7, day30));
			}
		}
		return dp[lastDay];
	}

	public static void main(String[] args) {
		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] costs = { 2, 7, 15 };
		
		int minCost = minCostTicket(days, costs);
		
		System.out.println(minCost);

	}

}
