package com.app.questions;

public class HouseRobber {
	private static int getMaxMoney(int[] cost) {
		if(cost.length == 0)
            return 0;
        if(cost.length == 1)
            return cost[0];
		int n = cost.length;
		int[] dp = new int[n];
		dp[0] = cost[0];
		dp[1] = Integer.max(cost[0], cost[1]);

		for (int i = 2; i < n; i++) {
			int option1 = dp[i - 2] + cost[i];
			int option2 = dp[i - 1];
			dp[i] = Integer.max(option1, option2);
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[] cost = { 1, 2, 3, 1 };

		int maxMoney = getMaxMoney(cost);

		System.out.println(maxMoney);

		cost = new int[] { 2, 7, 9, 3, 1 };

		maxMoney = getMaxMoney(cost);

		System.out.println(maxMoney);

	}

}
