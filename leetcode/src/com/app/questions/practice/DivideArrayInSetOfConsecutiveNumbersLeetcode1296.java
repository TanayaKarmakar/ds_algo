package com.app.questions.practice;

import java.util.TreeMap;

public class DivideArrayInSetOfConsecutiveNumbersLeetcode1296 {
	private static boolean canDivide(int[] nums, int k) {
		if (nums.length % k != 0)
			return false;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			}
		}

		while (map.size() > 0) {
			int firstKey = map.firstKey();
			for (int i = firstKey; i < firstKey + k; i++) {
				if (!map.containsKey(i))
					return false;
				int c = map.get(i);
				if (c == 1) {
					map.remove(i);
				} else {
					map.put(i, --c);
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 4, 4, 5, 6 };

		boolean canDivide = canDivide(nums, 4);

		System.out.println(canDivide);

		nums = new int[] { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 };

		canDivide = canDivide(nums, 3);

		System.out.println(canDivide);

		nums = new int[] { 3, 3, 2, 2, 1, 1 };

		canDivide = canDivide(nums, 3);

		System.out.println(canDivide);

		nums = new int[] { 1, 2, 3, 4 };

		canDivide = canDivide(nums, 3);

		System.out.println(canDivide);
	}

}
