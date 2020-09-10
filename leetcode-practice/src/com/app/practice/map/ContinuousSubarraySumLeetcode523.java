package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySumLeetcode523 {
	private static boolean checkSubarraySum(int[] nums, int k) {
		int preSum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int n = nums.length;

		map.put(0, -1);
		for (int i = 0; i < n; i++) {
			preSum += nums[i];
			preSum = preSum % k;
			if (map.containsKey(preSum)) {
				if (i - map.get(preSum) > 1)
					return true;
			} else {
				map.put(preSum, i);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 23, 2, 4, 6, 7 };
		
		boolean ans = checkSubarraySum(nums, 6);
		
		System.out.println(ans);
	}

}
