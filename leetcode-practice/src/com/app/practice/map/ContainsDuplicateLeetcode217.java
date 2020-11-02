package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateLeetcode217 {
	private static boolean containsDuplicate(int[] nums) {
		if(nums.length <= 1)
			return false;
		Map<Integer, Integer> map = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= 2)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		

	}

}
