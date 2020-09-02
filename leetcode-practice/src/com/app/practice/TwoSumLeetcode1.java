package com.app.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumLeetcode1 {
	private static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (numMap.containsKey(target - nums[i])) {
				int[] ans = new int[2];
				ans[0] = numMap.get(target - nums[i]);
				ans[1] = i;
				return ans;
			}
			numMap.put(nums[i], i);
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] nums = {};

		System.out.println(Arrays.toString(twoSum(nums, 10)));

		nums = new int[] { 2, 7, 11, 15 };
		
		System.out.println(Arrays.toString(twoSum(nums, 9)));
	}

}
