package com.app.practice;

import java.util.Arrays;

public class TargetSumLeetcode494 {
	private static int countWays(int[][] memo, int[] nums, int currentIndx, int currentSum, int targetSum) {
		if (currentIndx == nums.length) {
			if (currentSum == targetSum)
				return 1;
			else
				return 0;
		}
		if (memo[currentIndx][1000 + currentSum] == -1) {
			int option1 = countWays(memo, nums, currentIndx + 1, currentSum + nums[currentIndx], targetSum);
			int option2 = countWays(memo, nums, currentIndx + 1, currentSum - nums[currentIndx], targetSum);
			memo[currentIndx][1000 + currentSum] = option1 + option2;
		}
		return memo[currentIndx][1000 + currentSum];
	}

	private static int findNumWays(int[] nums, int s) {
		int n = nums.length;
		int[][] memo = new int[n][2001];
		for (int i = 0; i < n; i++) {
			Arrays.fill(memo[i], -1);
		}
		return countWays(memo, nums, 0, 0, s);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int S = 3;
		
		int numWays = findNumWays(nums, S);
		
		System.out.println(numWays);

	}

}
