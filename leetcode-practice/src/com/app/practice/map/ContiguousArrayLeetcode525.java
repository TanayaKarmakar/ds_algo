package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArrayLeetcode525 {
	private static int findMaxLength(int[] nums) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		int preSum = 0;

		int res = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] == 0)
				preSum -= 1;
			else
				preSum += nums[i];
			if (preSum == 0)
				res = i + 1;
			if (!map.containsKey(preSum))
				map.put(preSum, i);
			else
				res = Integer.max(res, i - map.get(preSum));
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0 };
		int res = findMaxLength(nums);
		
		System.out.println(res);
	}

}
