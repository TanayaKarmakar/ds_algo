package com.app.dynamicprogramming.classroom;

public class RangeQuery1DArray {
	private static int[] prefix;

	private static int rangeQuery(int start, int end) {
		if (start == 0)
			return prefix[end];
		return prefix[end] - prefix[start - 1];
	}

	private static void computePrefixSum(int[] nums) {
		int n = nums.length;
		prefix = new int[n];
		prefix[0] = nums[0];

		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i - 1] + nums[i];
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		computePrefixSum(nums);

		System.out.println(rangeQuery(1, 3));
		System.out.println(rangeQuery(2, 4));

	}

}
