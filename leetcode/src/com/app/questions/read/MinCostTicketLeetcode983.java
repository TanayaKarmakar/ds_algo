package com.app.questions.read;

import java.util.HashSet;
import java.util.Set;

public class MinCostTicketLeetcode983 {
	private static int minCostTickets(int[] days, int[] costs) {
		int lastDay = days[days.length - 1];
		Set<Integer> daySet = new HashSet<>();
		for (int day : days) {
			daySet.add(day);
		}

		int[] dp = new int[lastDay + 1];
		for (int i = 1; i <= lastDay; i++) {
			if (!daySet.contains(i)) {
				dp[i] = dp[i - 1];
				continue;
			}
			int option1 = dp[Integer.max(i - 1, 0)] + costs[0];
			int option2 = dp[Integer.max(i - 7, 0)] + costs[1];
			int option3 = dp[Integer.max(i - 30, 0)] + costs[2];
			dp[i] = Integer.min(option1, Integer.min(option2, option3));
		}
		return dp[lastDay];
	}

	public static void main(String[] args) {
		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] costs = { 2, 7, 15 };
		
		int minCost = minCostTickets(days, costs);
		System.out.println(minCost);
	}

}
