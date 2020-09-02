package com.app.practice;

import java.util.HashMap;

class EasyAddMap extends HashMap<Integer, Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void put(int key, int value) {
		super.put(key, this.get(key) + value);
	}

	public int get(int key) {
		return super.containsKey(key) ? super.get(key) : 0;
	}
}

public class SplitArrayIntoConsecutiveSubsequnecesLeetcode659 {
	private static boolean isPossible(int[] nums) {
		EasyAddMap freqMap = new EasyAddMap();
		EasyAddMap tailMap = new EasyAddMap();

		for (int num : nums) {
			freqMap.put(num, 1);
		}

		for (int num : nums) {
			if (freqMap.get(num) == 0)
				continue;
			else if (freqMap.get(num) > 0 && tailMap.get(num - 1) > 0) {
				freqMap.put(num, -1);
				tailMap.put(num - 1, -1);
				tailMap.put(num, 1);
			} else if (freqMap.get(num) > 0 && freqMap.get(num + 1) > 0 && freqMap.get(num + 2) > 0) {
				freqMap.put(num, -1);
				freqMap.put(num + 1, -1);
				freqMap.put(num + 2, -1);
				tailMap.put(num + 2, 1);
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 4, 5 };

		System.out.println(isPossible(nums));

		nums = new int[] { 1, 2, 3, 4, 4, 5 };

		System.out.println(isPossible(nums));
	}

}
