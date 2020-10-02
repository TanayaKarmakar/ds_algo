package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsKLeetcode325 {
	private static int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		int n = nums.length;
		int maxLen = 0;
		int preSum = 0;

		for (int i = 0; i < n; i++) {
			preSum += nums[i];

			if (preSum == k)
				maxLen = i + 1;
			if (!map.containsKey(preSum))
				map.put(preSum, i);
			if (map.containsKey(preSum - k))
				maxLen = Integer.max(maxLen, i - map.get(preSum - k));
		}

		return maxLen;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -1, 5, -2, 3 };
		int k = 3;

		int maxLen = maxSubArrayLen(nums, k);

		System.out.println(maxLen);
	}

}
