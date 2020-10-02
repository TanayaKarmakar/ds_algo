package com.app.practice.map;

import java.util.TreeMap;

public class DivideArrayInSetOfKConsecutiveNumbersLeetcode1296 {
	private static boolean isPossibleDivide(int[] nums, int k) {
		TreeMap<Integer, Integer> tMap = new TreeMap<>();

		for (int el : nums) {
			tMap.put(el, tMap.getOrDefault(el, 0) + 1);
		}

		while (tMap.size() > 0) {
			int first = tMap.firstKey();
			for (int i = first; i < (first + k); i++) {
				if (!tMap.containsKey(i))
					return false;
				int val = tMap.get(i);
				if (val == 1)
					tMap.remove(i);
				else
					tMap.put(i, val - 1);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 4, 4, 5, 6 };
		int k = 4;

		boolean ans = isPossibleDivide(nums, k);
		System.out.println(ans);

		nums = new int[] { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 };
		k = 3;

		ans = isPossibleDivide(nums, k);
		System.out.println(ans);

		nums = new int[] { 3, 3, 2, 2, 1, 1 };
		k = 3;

		ans = isPossibleDivide(nums, k);
		System.out.println(ans);

		nums = new int[] { 1, 2, 3, 4 };
		
		k = 3;

		ans = isPossibleDivide(nums, k);
		System.out.println(ans);
	}

}
