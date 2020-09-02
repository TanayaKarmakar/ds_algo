package com.app.practice.map;

import java.util.HashMap;

class EasyAddMap extends HashMap<Integer, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void add(int key, int val) {
		super.put(key, super.getOrDefault(key, 0) + val);
	}

	public int get(int key) {
		if (!super.containsKey(key))
			return 0;
		return super.get(key);
	}

}

public class SplitArrayIntoConsecutiveSubsequnecesLeetcode659 {
	private static boolean isPossible(int[] nums) {
		EasyAddMap freq = new EasyAddMap();
		EasyAddMap tail = new EasyAddMap();

		int n = nums.length;

		for (int i = 0; i < n; i++) {
			freq.add(nums[i], 1);
		}

		for (int i = 0; i < n; i++) {
			int num = nums[i];
			if (freq.get(num) == 0)
				continue;
			else if (freq.get(num) > 0 && tail.get(num - 1) > 0) {
				tail.add(num - 1, -1);
				freq.add(num, -1);
				tail.add(num, 1);
			} else if (freq.get(num) > 0 && freq.get(num + 1) > 0 && freq.get(num + 2) > 0) {
				tail.add(num + 2, 1);
				freq.add(num, -1);
				freq.add(num + 1, -1);
				freq.add(num + 2, -1);
			} else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 4, 5 };

		System.out.println(isPossible(nums));

		nums = new int[] { 1, 2, 3, 3, 4, 4, 5, 5 };

		System.out.println(isPossible(nums));

		nums = new int[] { 1, 2, 3, 4, 4, 5 };
		
		System.out.println(isPossible(nums));
	}

}
