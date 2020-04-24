package com.app.questions.read;

import java.util.TreeMap;

public class DivideAnArrayIntoSetOfConsecutiveNumbersLeetcode1296 {
	private static boolean isPossibleDivide(int[] nums, int k) {
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
			int first = map.firstKey();
			for (int i = first; i < first + k; i++) {
				if (!map.containsKey(i))
					return false;
				int c = map.get(i);
				if (c == 1) {
					map.remove(i);
				} else {
					c = c - 1;
					map.put(i, c);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TC1
		int[] nums = { 1, 2, 3, 3, 4, 4, 5, 6 };

		System.out.println(isPossibleDivide(nums, 4));

		// TC2
		nums = new int[] { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 };

		System.out.println(isPossibleDivide(nums, 3));

		// TC3
		nums = new int[] { 3, 3, 2, 2, 1, 1 };

		System.out.println(isPossibleDivide(nums, 3));

		// TC4

		nums = new int[] { 1, 2, 3, 4 };
		
		System.out.println(isPossibleDivide(nums, 3));

	}

}
