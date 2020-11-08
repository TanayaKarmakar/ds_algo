package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsKLeetcode325 {
	private static int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		int n = nums.length;
		int preSum = 0;

		int res = 0;

		for (int i = 0; i < n; i++) {
			preSum += nums[i];

			if (preSum == k)
				res = i + 1;
			if (map.containsKey(preSum - k))
				res = Integer.max(res, i - map.get(preSum - k));
			if(!map.containsKey(preSum))
				map.put(preSum, i);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -1, 5, -2, 3 };
		int k = 3;
		
		int ans = maxSubArrayLen(nums, k);
		
		System.out.println(ans);
	}

}
