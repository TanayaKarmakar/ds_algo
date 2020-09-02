package com.app.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArrayLeetcode697 {
	private static int degreeOfAnArray(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int maxFreq = 1;
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				List<Integer> indices = new ArrayList<>();
				indices.add(i);
				map.put(nums[i], indices);
			} else {
				map.get(nums[i]).add(i);
			}
			maxFreq = Integer.max(maxFreq, map.get(nums[i]).size());
		}

		int minDiff = nums.length - 1;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == maxFreq) {
				int currentDiff = entry.getValue().get(entry.getValue().size() - 1) - entry.getValue().get(0) + 1;

				minDiff = Integer.min(minDiff, currentDiff);
			}
		}

		return minDiff;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 1 };
		int val = degreeOfAnArray(nums);

		System.out.println(val);

		nums = new int[] { 1, 2, 2, 3, 1, 4, 2 };
		val = degreeOfAnArray(nums);

		System.out.println(val);
	}

}
