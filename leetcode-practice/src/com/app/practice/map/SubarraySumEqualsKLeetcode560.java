package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsKLeetcode560 {
	private static int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int preSum = 0;

		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			preSum += nums[i];
			if (map.containsKey(preSum - k)) {
				count += map.get(preSum - k);
			}
			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1 };
		int k = 2;
		
		int ans = subarraySum(nums, k);
		
		System.out.println(ans);

	}

}
