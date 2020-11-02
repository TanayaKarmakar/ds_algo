package com.app.practice.sort;

import java.util.Arrays;

public class NumberSmallerThanCurrentNumber1365 {
	private static int[] smallerNumbersThanCurrent(int[] nums) {
		int n = nums.length;

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Integer.max(max, nums[i]);
		}

		int[] count = new int[max + 1];
		for (int i = 0; i < n; i++) {
			count[nums[i]]++;
		}

		for (int i = 1; i <= max; i++) {
			count[i] = count[i - 1] + count[i];
		}

		for (int i = 0; i < n; i++) {
			int k = nums[i];
			if(k > 0)
			    nums[i] = count[k - 1];
		}

		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 8, 1, 2, 2, 3 };
		
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));

	}

}
