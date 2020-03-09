package com.app.timecomplexity.problems;

public class KConcatenationMaxSum {
	private static int kadanesSum(int[] nums, int n) {
		int totalSum = Integer.MIN_VALUE;
		int currentSum = 0;
		for (int i = 0; i < n; i++) {
			currentSum += nums[i];
			if (currentSum > totalSum) {
				totalSum = currentSum;
			}
			if (currentSum < 0) {
				currentSum = 0;
			}
		}

		return totalSum;
	}

	private static int findMaxSum(int[] nums, int n, int k) {
		int kadanesSum = kadanesSum(nums, n);
		if (k == 1)
			return kadanesSum;
		int maxPrefixSum = Integer.MIN_VALUE;
		int maxSuffixSum = Integer.MIN_VALUE;
		int currentPrefixSum = 0;
		int currentSuffixSum = 0;
		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			currentPrefixSum += nums[i];
			maxPrefixSum = Integer.max(maxPrefixSum, currentPrefixSum);
		}

		totalSum = currentPrefixSum;

		for (int i = n - 1; i >= 0; i--) {
			currentSuffixSum += nums[i];
			maxSuffixSum = Integer.max(maxSuffixSum, currentSuffixSum);
		}

		int res = 0;
		if (totalSum < 0) {
			res = Integer.max(maxPrefixSum + maxSuffixSum, kadanesSum);
		} else {
			res = Integer.max(maxPrefixSum + maxSuffixSum + ((k - 2) * totalSum), kadanesSum);
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println("Max Sum - " + findMaxSum(new int[] { 1, -2, 1 }, 3, 3));
		System.out.println("Max Sum - " + findMaxSum(new int[] { 1, -2, -1 }, 3, 3));
	}

}
