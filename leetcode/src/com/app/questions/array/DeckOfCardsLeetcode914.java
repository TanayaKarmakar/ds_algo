package com.app.questions.array;

import java.util.HashMap;
import java.util.Map;

public class DeckOfCardsLeetcode914 {
	private static boolean hasGroupSizeX(int[] deck) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : deck) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int g = -1;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int val = entry.getValue();
			if (g == -1) {
				g = val;
			} else {
				g = gcd(g, val);
			}
		}
		return g >= 2 ? true : false;
	}

	private static int gcd(int x, int y) {
		return (x == 0) ? y : gcd(y % x, x);
	}

	public static void main(String[] args) {
		int[] deck = { 1, 2, 3, 4, 4, 3, 2, 1 };

		boolean canArrange = hasGroupSizeX(deck);

		System.out.println(canArrange);

		deck = new int[] { 1, 1, 1, 2, 2, 2, 3, 3 };
		
		canArrange = hasGroupSizeX(deck);

		System.out.println(canArrange);
	}

}
