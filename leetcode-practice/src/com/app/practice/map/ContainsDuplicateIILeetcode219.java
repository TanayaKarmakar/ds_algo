package com.app.practice.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateIILeetcode219 {
	private static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		int n = nums.length;

		for (int i = 0; i < n; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], new ArrayList<>());
			map.get(nums[i]).add(i);
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() > 1) {
				List<Integer> values = entry.getValue();
				for (int i = 1; i < values.size(); i++) {
					if (values.get(i) - values.get(i - 1) <= k)
						return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1, 2, 3 };
		int k = 2;

		System.out.println(containsNearbyDuplicate(nums, k));

		nums = new int[] { 1, 2, 3, 1 };
		k = 3;
		
		System.out.println(containsNearbyDuplicate(nums, k));
	}

}
