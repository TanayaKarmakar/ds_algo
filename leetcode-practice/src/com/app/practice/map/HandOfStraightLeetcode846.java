package com.app.practice.map;

import java.util.TreeMap;

public class HandOfStraightLeetcode846 {
	private static boolean isNStraightHand(int[] hand, int W) {
		TreeMap<Integer, Integer> tMap = new TreeMap<>();
		for (int i = 0; i < hand.length; i++) {
			tMap.put(hand[i], tMap.getOrDefault(hand[i], 0) + 1);
		}

		while (tMap.size() > 0) {
			int start = tMap.firstKey();
			for (int i = start; i < (start + W); i++) {
				if (!tMap.containsKey(i))
					return false;
				int count = tMap.get(i);
				if (count == 1)
					tMap.remove(i);
				else
					tMap.put(i, --count);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] hands = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		int W = 3;
		
		boolean isPossible = isNStraightHand(hands, W);
		
		System.out.println(isPossible);

	}

}
