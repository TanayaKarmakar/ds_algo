package com.app.questions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEqual01 {
	private static int largestSubarray(int[] nums) {
		int res = 0;
		int preSum = 0;
		int n = nums.length;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				preSum -= 1;
			} else {
				preSum += nums[i];
			}

			if (preSum == 0)
				res = i + 1;
			if (!map.containsKey(preSum))
				map.put(preSum, i);
			if (map.containsKey(preSum))
				res = Integer.max(res, i - map.get(preSum));
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1 };

		int maxLen = largestSubarray(nums);

		System.out.println(maxLen);

		nums = new int[] { 0, 1, 0 };

		maxLen = largestSubarray(nums);

		System.out.println(maxLen);

		nums = new int[] { 1, 0, 1, 1, 0, 1, 0, 0, 1 };
		
		maxLen = largestSubarray(nums);

		System.out.println(maxLen);

	}

}
