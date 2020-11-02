package com.app.practice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArrayLeetcode697 {
	private static int findShortestSubArray(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int maxDeg = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new ArrayList<>());
			}
			map.get(nums[i]).add(i);
			maxDeg = Integer.max(map.get(nums[i]).size(), maxDeg);
		}

		int minLen = nums.length;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == maxDeg) {
				int size = entry.getValue().size();
				int diff = entry.getValue().get(size - 1) - entry.getValue().get(0) + 1;
				minLen = Integer.min(minLen, diff);
			}
		}

		return minLen;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 1 };
		
		int ans = findShortestSubArray(nums);
		
		System.out.println(ans);

	}

}
