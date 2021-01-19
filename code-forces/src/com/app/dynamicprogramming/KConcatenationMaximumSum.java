package com.app.dynamicprogramming;

public class KConcatenationMaximumSum {
	private static int kadanes(int[] nums) {
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			currentSum += nums[i];

			if (currentSum < 0)
				currentSum = 0;
			maxSum = Integer.max(maxSum, currentSum);
		}

		return maxSum;
	}

	private static int kadanesOfTwo(int[] nums) {
		int[] newArr = new int[2 * nums.length];

		for (int i = 0; i < nums.length; i++) {
			newArr[i] = nums[i];
			newArr[i + nums.length] = nums[i];
		}

		return kadanes(newArr);
	}

	private static int maxSum(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		if (k == 1) {
			return kadanes(nums);
		} else if (sum < 0) {
			return kadanesOfTwo(nums);
		} else {
			return kadanesOfTwo(nums) + (k - 2) * sum;
		}
	}

	public static void main(String[] args) {
		int[] nums = {2, -3, -3, 2};
		
		int k = 3;
		
		int maxSum = maxSum(nums, k);
		
		System.out.println(maxSum);
	}

}
