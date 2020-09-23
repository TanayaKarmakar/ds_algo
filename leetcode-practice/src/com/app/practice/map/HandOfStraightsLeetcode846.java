package com.app.practice.map;

import java.util.TreeMap;

public class HandOfStraightsLeetcode846 {
	private static boolean isNStraightHand(int[] hand, int W) {
		TreeMap<Integer, Integer> tMap = new TreeMap<>();
		for (int el : hand) {
			tMap.put(el, tMap.getOrDefault(el, 0) + 1);
		}

		while (tMap.size() > 0) {
			int first = tMap.firstKey();
			for (int i = first; i < (first + W); i++) {
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
		int[] nums = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		int W = 3;

		boolean ans = isNStraightHand(nums, W);

		System.out.println(ans);

		nums = new int[] { 1, 2, 3, 4, 5 };
		W = 4;
		
		ans = isNStraightHand(nums, W);

		System.out.println(ans);

	}

}
