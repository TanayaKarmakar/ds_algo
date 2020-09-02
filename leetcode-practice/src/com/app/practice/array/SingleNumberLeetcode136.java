package com.app.practice.array;

public class SingleNumberLeetcode136 {
	private static int singleNumber(int[] nums) {
		int total = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			total ^= nums[i];
		}
		return total;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1 };

		System.out.println(singleNumber(nums));
	}

}
