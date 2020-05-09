package com.app.questions.practice;

import java.util.HashMap;

class EasyAddMap extends HashMap<Integer, Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void add(int key, int val) {
		if (!super.containsKey(key)) {
			super.put(key, val);
		} else {
			int v = super.get(key);
			super.put(key, v + val);
		}
	}

	public int get(int key) {
		return super.getOrDefault(key, 0);
	}
}

public class SplitArrayIntoConsecutiveSubsequencesLeetcode659 {
	private static boolean isPossible(int[] nums) {
		EasyAddMap countMap = new EasyAddMap();
		EasyAddMap tailMap = new EasyAddMap();

		for (int el : nums) {
			countMap.add(el, 1);
		}

		for (int el : nums) {
			if (countMap.get(el) == 0)
				continue;
			else if (countMap.get(el) > 0 && tailMap.get(el - 1) > 0) {
				countMap.add(el, -1);
				tailMap.add(el - 1, -1);
				tailMap.add(el, 1);
			} else if (countMap.get(el) > 0 && countMap.get(el + 1) > 0 && countMap.get(el + 2) > 0) {
				tailMap.add(el + 2, 1);
				countMap.add(el, -1);
				countMap.add(el + 1, -1);
				countMap.add(el + 2, -1);
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
