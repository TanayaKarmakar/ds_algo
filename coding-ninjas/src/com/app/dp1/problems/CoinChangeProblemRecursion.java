package com.app.dp1.problems;

public class CoinChangeProblemRecursion {
	private static int coinChange(int[] nums, int total, int startIndx) {
		if (total == 0)
			return 1;
		if (total < 0 || startIndx == nums.length)
			return 0;

		int option1 = coinChange(nums, total - nums[startIndx], startIndx);
		int option2 = coinChange(nums, total, startIndx + 1);

		return option1 + option2;
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		int total = 4;
		
		int numWays = coinChange(coins, total, 0);
		
		System.out.println(numWays);
	}

}
