package com.app.problems.gfg.dp.sample;

public class SubsetSumProblem {
	private static boolean recHelper(int[] nums, int target, int indx) {
		if (target == 0)
			return true;
		if (target < 0 || indx >= nums.length)
			return false;
		boolean option1 = recHelper(nums, target, indx + 1);
		boolean option2 = recHelper(nums, target - nums[indx], indx + 1);
		return option1 || option2;
	}

	private static boolean recursion(int[] nums, int target) {
		return recHelper(nums, target, 0);
	}
	
	private static boolean tabulation(int[] nums, int target) {
		int n = nums.length;
		boolean[][] dp = new boolean[n][target + 1];
		
		for(int i = 0; i < n; i++) {
			dp[i][0] = true;
		}
		
		for(int i = 1; i <= target; i++) {
			if(i == nums[0])
				dp[0][i] = true;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= target; j++) {
				if(dp[i - 1][j])
					dp[i][j] = dp[i - 1][j];
				if(j >= nums[i])
					dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i]];
			}
		}
		
		return dp[n - 1][target];
	}

	public static void main(String[] args) {
		int[] nums = { 3, 34, 4, 12, 5, 2 };
		int target = 9;

		boolean hasSum = recursion(nums, target);

		System.out.println("Recursion - " + hasSum);
		
		hasSum = tabulation(nums, target);
		
		System.out.println("Tabulation - " + hasSum);

		nums = new int[] { 3, 34, 4, 12, 5, 2 };
		target = 30;
		
		hasSum = recursion(nums, target);

		System.out.println("Recursion - " + hasSum);
		
		hasSum = tabulation(nums, target);
		
		System.out.println("Tabulation - " + hasSum);

	}

}
