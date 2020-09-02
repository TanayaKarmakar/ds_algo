package com.app.practice;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsKLeetcode560 {
	private static int subArraySum(int[] nums, int k) {
		int n = nums.length;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, 1);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1 };
		
		int count = subArraySum(nums, 2);
		
		System.out.println(count);
	}

}
