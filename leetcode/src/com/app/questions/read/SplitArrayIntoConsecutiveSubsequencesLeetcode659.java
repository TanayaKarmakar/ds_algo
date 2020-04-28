package com.app.questions.read;

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
		return super.containsKey(key) ? super.get(key): 0;
	}
}

public class SplitArrayIntoConsecutiveSubsequencesLeetcode659 {
	private static boolean isPossible(int[] nums) {
		EasyAddMap freqMap = new EasyAddMap();
		EasyAddMap tail = new EasyAddMap();

		for (int num : nums) {
			freqMap.put(num, 1);
		}

		for (int el : nums) {
			if (freqMap.get(el) == 0)
				continue;
			else if (freqMap.get(el) > 0 && tail.get(el - 1) > 0) {
				freqMap.put(el, -1);
				tail.put(el - 1, -1);
				tail.put(el, 1);
			} else if (freqMap.get(el) > 0 && freqMap.get(el + 1) > 0 && freqMap.get(el + 2) > 0) {
				tail.put(el + 2, 1);
				freqMap.put(el, -1);
				freqMap.put(el + 1, -1);
				freqMap.put(el + 2, -1);
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TC1
		/*int[] nums = { 1, 2, 3, 3, 4, 5 };

		System.out.println(isPossible(nums));

		// TC2
		nums = new int[] { 1, 2, 3, 3, 4, 4, 5, 5 };

		System.out.println(isPossible(nums));

		nums = new int[] { 10, 10, 10 };

		System.out.println(isPossible(nums));*/

		int[] nums = new int[] { 1, 2, 3, 4, 4, 5 };

		System.out.println(isPossible(nums));

		/*nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

		System.out.println(isPossible(nums));

		nums = new int[] { 4, 5, 6, 7, 7, 8, 8, 9, 10, 11 };

		System.out.println(isPossible(nums));*/
	}

}
