package com.app.dynamicprogramming.classroom;

public class MinimumCoinChangeProblemRecursion {
	private static int minCoinChange(int[] coins, int val) {
		if (val == 0)
			return 0;
		int n = coins.length;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int currentVal = coins[i];
			if (currentVal <= val) {
				int subRes = minCoinChange(coins, val - currentVal);
				if (subRes != Integer.MAX_VALUE) {
					res = Integer.min(res, subRes + 1);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] coins = { 25, 10, 5 };
		int val = 30;

		int minNumberCoins = minCoinChange(coins, val);
		System.out.println("Minimum value - " + minNumberCoins);

	}

}
