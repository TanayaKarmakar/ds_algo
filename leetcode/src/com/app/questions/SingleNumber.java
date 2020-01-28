package com.app.questions;

public class SingleNumber {
	private static int singleNumber(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum ^= nums[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1 };

		System.out.println(singleNumber(nums));

		nums = new int[] { 4, 1, 2, 1, 2 };

		System.out.println(singleNumber(nums));
	}

}
