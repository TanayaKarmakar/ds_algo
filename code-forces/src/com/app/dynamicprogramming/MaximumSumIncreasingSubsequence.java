package com.app.dynamicprogramming;

public class MaximumSumIncreasingSubsequence {
	private static int maxSum(int[] nums) {
		int n = nums.length;
		int[] lisSum = new int[n];

		lisSum[0] = nums[0];
		int maxSum = nums[0];

		for (int i = 1; i < n; i++) {
			lisSum[i] = nums[i];
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					lisSum[i] = Integer.max(lisSum[i], nums[i] + lisSum[j]);
				}
			}
			maxSum = Integer.max(maxSum, lisSum[i]);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 3 };
		int maxSum = maxSum(nums);
		
		System.out.println(maxSum);

	}

}
