package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsKLeetcode325 {
	private static int maxSubarrayLen(int[] nums, int k) {
		int preSum = 0;
		int n = nums.length;
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			preSum += nums[i];

			if (preSum == k)
				res = i + 1;
			if (!map.containsKey(preSum))
				map.put(preSum, i);
			if (map.containsKey(preSum - k))
				res = Integer.max(res, i - map.get(preSum - k));
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -1, 5, -2, 3 };
		int k = 3;

		int res = maxSubarrayLen(nums, k);
		
		System.out.println(res);
	}

}
