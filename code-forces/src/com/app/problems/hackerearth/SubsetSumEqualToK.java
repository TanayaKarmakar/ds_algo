package com.app.problems.hackerearth;

public class SubsetSumEqualToK {
	private static boolean isPossible(int[] nums, int k) {
		int n = nums.length;
		int end = (1 << n);

		for (int i = 0; i < end; i++) {
			int currentSum = 0;
			int number = i;
			for (int j = 0; j < n; j++) {
				if ((number & (1 << j)) != 0) {
					currentSum += nums[j];
					if (currentSum == k)
						return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 15, 20, 25, 30 };

		System.out.println(isPossible(nums, 65));
		System.out.println(isPossible(nums, 66));

	}

}
