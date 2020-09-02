package com.app.practice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArrayLeetcode697 {
	private static int degreeOfAnArray(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int n = nums.length;

		int maxLen = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new ArrayList<>());
			}
			map.get(nums[i]).add(i);
			maxLen = Integer.max(maxLen, map.get(nums[i]).size());
		}

		int minLen = Integer.MAX_VALUE;

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == maxLen) {
				List<Integer> indices = entry.getValue();
				int len = indices.get(indices.size() - 1) - indices.get(0) + 1;
				minLen = Integer.min(minLen, len);
			}
		}

		return minLen;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 1 };

		int minLen = degreeOfAnArray(nums);

		System.out.println(minLen);

		nums = new int[] { 1, 2, 2, 3, 1, 4, 2 };
		
		minLen = degreeOfAnArray(nums);

		System.out.println(minLen);

	}

}
