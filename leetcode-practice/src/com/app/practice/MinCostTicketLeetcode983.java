package com.app.practice;

import java.util.HashSet;
import java.util.Set;

public class MinCostTicketLeetcode983 {
	private static int minCostTicket(int[] days, int[] costs) {
		int last = days[days.length - 1];
		int[] dp = new int[last + 1];

		Set<Integer> daySet = new HashSet<>();
		for (int day : days) {
			daySet.add(day);
		}

		for (int i = 1; i <= last; i++) {
			if (!daySet.contains(i)) {
				dp[i] = dp[i - 1];
			} else {
				int day1 = dp[Integer.max(i - 1, 0)] + costs[0];
				int day7 = dp[Integer.max(i - 7, 0)] + costs[1];
				int day30 = dp[Integer.max(i - 30, 0)] + costs[2];
				dp[i] = Integer.min(day1, Integer.min(day7, day30));
			}
		}
		return dp[last];
	}

	public static void main(String[] args) {
		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] costs = { 2, 7, 15 };

		int output = minCostTicket(days, costs);

		System.out.println(output);

		days = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 };
		costs = new int[] { 2, 7, 15 };
		
		output = minCostTicket(days, costs);

		System.out.println(output);
	}

}
