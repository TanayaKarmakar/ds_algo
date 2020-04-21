package com.app.questions.practice;

import java.util.Arrays;

public class TargetSumLeetcode494 {
	private static int count = 0;
	
	private static int targetSumRec(int[][] memo, int[] nums, int currentIndx, int currentSum, int targetSum) {
		if(currentIndx == nums.length) {
			if(currentSum == targetSum)
				return 1;
			else
				return 0;
		}
		if(memo[currentIndx][currentSum + 1000] == -1) {
			int option1 = targetSumRec(memo, nums, currentIndx + 1, currentSum + nums[currentIndx], targetSum);
			int option2 = targetSumRec(memo, nums, currentIndx + 1, currentSum - nums[currentIndx], targetSum);
			memo[currentIndx][currentSum + 1000] = option1 + option2;
		}
		return memo[currentIndx][currentSum + 1000];
	}
	
	private static int targetSumMemo(int[] nums, int targetSum) {
		int[][] memo = new int[nums.length][2000 + 1];
		
		for(int i = 0; i < nums.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		return targetSumRec(memo, nums, 0, 0, targetSum);
	}
	
	private static int targetSum(int[] nums, int indx, int targetSum, int currentSum) {
		if (indx == nums.length) {
			if(targetSum == currentSum)
				return 1;
			else
				return 0;
		} else {
			count = targetSum(nums, indx + 1, targetSum, currentSum - nums[indx]);
			count += targetSum(nums, indx + 1, targetSum, currentSum + nums[indx]);
			return count;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int sum = 3;

		int numWays = targetSumMemo(nums, sum);

		System.out.println(numWays);

	}

}
