package com.app.practice.array;

import java.util.TreeMap;

public class DivideTheArrayInSetOfKConsecutiveNumbersLeetcode1296 {
	private static boolean isPossibleDivide(int[] nums, int k) {
		TreeMap<Integer, Integer> tMap = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			tMap.put(nums[i], tMap.getOrDefault(nums[i], 0) + 1);
		}

		while (tMap.size() > 0) {
			int start = tMap.firstKey();
			for (int i = start; i < start + k; i++) {
				if (!tMap.containsKey(i))
					return false;
				int val = tMap.get(i);
				if (val == 1)
					tMap.remove(i);
				else
					tMap.put(i, --val);
			}
		}
		
		return true;
	}

	public static void main(String[] args) {

	}

}
