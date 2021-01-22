package com.app.dynamicprogramming;

public class MaximumSumAtLeastK {
	private static int maxSumAtLeastK(int[] nums, int k) {
		int[] maxSum = new int[nums.length];

		int currentSum = nums[0];
		maxSum[0] = currentSum;
		for (int i = 1; i < nums.length; i++) {
			if (currentSum < 0) {
				currentSum = nums[i];
			} else {
				currentSum += nums[i];
			}
			maxSum[i] = currentSum;
		}

		int ans = Integer.MIN_VALUE;
		int exactKSum = 0;
		for (int i = 0; i < k; i++) {
			exactKSum += nums[i];
		}

		ans = Integer.max(ans, exactKSum);

		for (int i = k; i < nums.length; i++) {
			exactKSum += (nums[i] - nums[i - k]);
			int moreThanKSum = exactKSum + maxSum[i - k];

			ans = Integer.max(ans, Integer.max(exactKSum, moreThanKSum));
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, -7, 6, -5, -4, 4, 3, 3, 2, -9, -5, 6, 1, 2, 1, 4 };
		int k = 4;
		int ans = maxSumAtLeastK(nums, k);

		System.out.println(ans);

	}

}
