package com.app.search;

import java.util.List;

public class FindTheMissingElement {
	private static int[] findMissingElement(List<Integer> list) {
		int missXorDup = 0;
		for (int i = 0; i < list.size(); i++) {
			missXorDup ^= (i ^ list.get(i));
		}

		int missOrDup = 0;
		int differBit = missXorDup & (~(missXorDup - 1));

		for (int i = 0; i < list.size(); i++) {
			if ((i & differBit) != 0)
				missOrDup ^= i;

			if ((list.get(i) & differBit) != 0)
				missOrDup ^= list.get(i);
		}

		if (list.contains(missOrDup))
			return new int[] {missOrDup, missXorDup ^ missOrDup};
		return new int[] {missOrDup ^ missXorDup, missOrDup};
	}

	public static void main(String[] args) {
		List<Integer> list = List.of(5, 3, 0, 3, 1, 2);
		int[] ans = findMissingElement(list);
		
		System.out.println("Duplicate - " + ans[0] + ": Missing - " + ans[1]);

	}

}
