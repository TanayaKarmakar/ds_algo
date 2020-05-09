package com.app.questions.practice;

import java.util.TreeMap;

public class HandOfStraightLeetcode846 {
	private static boolean isNStraightHand(int[] hand, int W) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int el : hand) {
			map.put(el, map.getOrDefault(el, 0) + 1);
		}

		while (map.size() > 0) {
			int firstKey = map.firstKey();
			for (int i = firstKey; i < firstKey + W; i++) {
				if (!map.containsKey(i))
					return false;
				int val = map.get(i);
				if (val == 1)
					map.remove(i);
				else {
					map.put(i, --val);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		int W = 3;

		boolean isPossible = isNStraightHand(hand, W);
		System.out.println(isPossible);

		hand = new int[] { 1, 2, 3, 4, 5 };
		W = 4;
		
		isPossible = isNStraightHand(hand, W);
		System.out.println(isPossible);

	}

}
