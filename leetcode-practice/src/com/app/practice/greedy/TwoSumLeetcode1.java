package com.app.practice.greedy;

import java.util.Arrays;

public class TwoSumLeetcode1 {
	private static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		Arrays.sort(nums);

		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			if (nums[start] + nums[end] == target) {
				res[0] = start;
				res[1] = end;
				return res;
			} else if (nums[start] + nums[end] > target) {
				end--;
			} else {
				start++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		
		int[] res = twoSum(nums, target);
		
		System.out.println(Arrays.toString(res));

	}

}
