package com.app.timecomplexity.problems;

//maximum sum subarray
public class KadanesAlgorithm {
	private static int maxSum(int[] nums) {
		int n = nums.length;
		int currentSum = 0;
		int bestSum = 0;
		for (int i = 0; i < n; i++) {
			currentSum += nums[i];
			if (bestSum < currentSum) {
				bestSum = currentSum;
			}
			if (currentSum < 0) {
				currentSum = 0;
			}
		}
		return bestSum;
	}

	public static void main(String[] args) {
		int[] nums = { -5, 6, 7, -20, 3, 5, 8, -9 };
		int bestSum = maxSum(nums);

		System.out.println("BestSum - " + bestSum);
	}

}
