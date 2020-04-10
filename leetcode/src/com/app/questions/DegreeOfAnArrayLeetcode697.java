package com.app.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArrayLeetcode697 {
	private static int getShortestSubarray(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int n = nums.length;

		int maxFreq = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(nums[i])) {
				List<Integer> indices = new ArrayList<>();
				indices.add(i);
				map.put(nums[i], indices);
			} else {
				map.get(nums[i]).add(i);
			}
			maxFreq = Integer.max(maxFreq, map.get(nums[i]).size());
		}

		int diff = Integer.MAX_VALUE;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> indices = entry.getValue();
			if (indices.size() == maxFreq) {
				int currentDiff = indices.get(indices.size() - 1) - indices.get(0);
				diff = Integer.min(diff, currentDiff);
			}
		}
		return diff + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 1 };

		System.out.println(getShortestSubarray(nums));

		nums = new int[] { 1, 2, 2, 3, 1, 4, 2 };

		System.out.println(getShortestSubarray(nums));

	}

}
