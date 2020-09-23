package com.app.practice.map;

import java.util.HashMap;

class EasyAddMap extends HashMap<Integer, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void put(int key, int value) {
		super.put(key, super.getOrDefault(key, 0) + value);
	}

	public int get(int key) {
		return super.getOrDefault(key, 0);
	}

}

public class SplitArrayIntoConsecutiveSubsequencesLeetcode659 {

	private static boolean isPossible(int[] nums) {
		EasyAddMap freqMap = new EasyAddMap();
		EasyAddMap tailMap = new EasyAddMap();

		for (int el : nums) {
			freqMap.put(el, 1);
		}

		for (int el : nums) {
			if (freqMap.get(el) == 0)
				continue;
			else if (freqMap.get(el) > 0 && tailMap.get(el - 1) > 0) {
				tailMap.put(el, 1);
				tailMap.put(el - 1, -1);
				freqMap.put(el, -1);
			} else if (freqMap.get(el) > 0 && freqMap.get(el + 1) > 0 && freqMap.get(el + 2) > 0) {
				tailMap.put(el + 2, 1);
				freqMap.put(el, -1);
				freqMap.put(el + 1, -1);
				freqMap.put(el + 2, -1);
			} else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 4, 4, 5, 5 };
		boolean ans = isPossible(nums);

		System.out.println(ans);

		nums = new int[] { 1, 2, 3, 4, 4, 5 };
		
		ans = isPossible(nums);

		System.out.println(ans);
	}

}
