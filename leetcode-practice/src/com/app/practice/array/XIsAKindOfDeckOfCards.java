package com.app.practice.array;

import java.util.HashMap;
import java.util.Map;

public class XIsAKindOfDeckOfCards {
	private static int gcd(int x, int y) {
		return (x == 0) ? y : gcd(y % x, x);
	}

	private static boolean hasGroupsSizeX(int[] deck) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int el : deck) {
			map.put(el, map.getOrDefault(el, 0) + 1);
		}

		int g = -1;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int val = entry.getValue();
			if (g == -1)
				g = val;
			else
				g = gcd(g, val);
		}

		if (g >= 2)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int[] deck = { 1, 2, 3, 4, 4, 3, 2, 1 };

		boolean isPossible = hasGroupsSizeX(deck);

		System.out.println(isPossible);

		deck = new int[] { 1, 1, 1, 2, 2, 2, 3, 3 };

		isPossible = hasGroupsSizeX(deck);

		System.out.println(isPossible);

		deck = new int[] { 1 };

		isPossible = hasGroupsSizeX(deck);

		System.out.println(isPossible);

		deck = new int[] { 1, 1 };

		isPossible = hasGroupsSizeX(deck);

		System.out.println(isPossible);

		deck = new int[] { 1, 1, 2, 2, 2, 2 };
		
		isPossible = hasGroupsSizeX(deck);

		System.out.println(isPossible);
	}

}
