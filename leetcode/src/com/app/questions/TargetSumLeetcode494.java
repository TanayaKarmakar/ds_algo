package com.app.questions;

import java.util.Arrays;

public class TargetSumLeetcode494 {
	private static int countWays(int[][] dp, int[] nums, int currentIndx, int currentSum, int sum) {
		if(currentIndx == nums.length) {
			if(currentSum == sum)
				return 1;
			else
				return 0;
		} else {
			if(dp[currentIndx][currentSum + 1000] == -1) {
				int option1 = countWays(dp, nums, currentIndx + 1, currentSum + nums[currentIndx], sum);
				int option2 = countWays(dp, nums, currentIndx + 1, currentSum - nums[currentIndx], sum);
				dp[currentIndx][currentSum + 1000] = option1 + option2;
			}
			return dp[currentIndx][currentSum + 1000];
		}
	}
	
	private static int findTargetSumNumWays(int[] nums, int sum) {
		int[][] dp = new int[nums.length][2001];
		for(int i = 0; i < nums.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return countWays(dp, nums, 0, 0, sum);
		/*if(nums.length == 0)
			return 1;
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}

		int targetSum = (totalSum + sum);
		if (targetSum % 2 != 0)
			return 0;

		targetSum = targetSum / 2;
		int n = nums.length;
		int[][] dp = new int[n][targetSum + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= targetSum; i++) {
			if (i == nums[0]) {
				dp[0][i] = 1;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= targetSum; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= nums[i]) {
					dp[i][j] += dp[i - 1][j - nums[i]];
				}
			}
		}

		return dp[n - 1][targetSum];*/
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int sum = 3;
		
		int totalWays = findTargetSumNumWays(nums, sum);
		
		System.out.println(totalWays);

	}

}
