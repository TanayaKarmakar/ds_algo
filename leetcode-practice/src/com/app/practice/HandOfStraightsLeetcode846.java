package com.app.practice;

import java.util.TreeMap;

public class HandOfStraightsLeetcode846 {
	private static boolean isNStraightHand(int[] hand, int W) {
		int n = hand.length;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			treeMap.put(hand[i], treeMap.getOrDefault(hand[i], 0) + 1);
		}

		while (treeMap.size() > 0) {
			int first = treeMap.firstKey();
			for (int i = first; i < first + W; i++) {
				if (!treeMap.containsKey(i))
					return false;
				int val = treeMap.get(i);
				if (val == 1)
					treeMap.remove(i);
				else
					treeMap.put(i, --val);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		int W = 3;

		System.out.println(isNStraightHand(hand, W));

		hand = new int[] { 1, 2, 3, 4, 5 };
		W = 4;
		
		System.out.println(isNStraightHand(hand, W));

	}

}
