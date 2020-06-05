package com.app.dpbitmasking.problems;

public class SubsetSumUptoK {
	private static int subsetSumUptoK(int[] nums, int k) {
		int n = nums.length;
		int count = 0;

		for (int i = 0; i < (int) Math.pow(2, n); i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					sum += nums[j];
				}
			}
			if (sum == k)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		
		int k = 2;
		
		int count = subsetSumUptoK(nums, k);
		
		System.out.println(count);

	}

}
