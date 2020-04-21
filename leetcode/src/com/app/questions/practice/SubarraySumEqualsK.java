package com.app.questions.practice;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	private static int count(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		int n = nums.length;

		map.put(0, 1);

		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum - k, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count(new int[] { 1, 1, 1 }, 2));

	}

}
