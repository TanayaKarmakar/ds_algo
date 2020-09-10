package com.app.septemberchallenge;

import java.util.HashMap;
import java.util.Map;

public class LargestTimeForGivenDigits {
	private static int search(Map<Integer, Integer> map, int low, int high) {
		for (int i = high; i >= low; i--) {
			if (map.containsKey(i))
				return i;
		}
		return -1;
	}

	private static void removeItem(Map<Integer, Integer> map, int item) {
		if (map.get(item) == 1)
			map.remove(item);
		else
			map.put(item, map.get(item) - 1);
	}

	private static String largestTimeFromDigits(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int el : A) {
			map.put(el, map.getOrDefault(el, 0) + 1);
		}

		int pos1 = search(map, 0, 2);
		if (pos1 == -1)
			return "";

		removeItem(map, pos1);

		int pos2 = -1;
		if (pos1 <= 1)
			pos2 = search(map, 0, 9);
		if (pos1 == 2)
			pos2 = search(map, 0, 3);

		if (pos2 == -1)
			return "";

		removeItem(map, pos2);

		int pos3 = search(map, 0, 5);
		if (pos3 == -1)
			return "";

		removeItem(map, pos3);

		int pos4 = search(map, 0, 9);
		removeItem(map, pos4);

		String str = pos1 + "" + pos2 + ":" + pos3 + "" + pos4;
		return str;

	}

	public static void main(String[] args) {
		int[] nums = { 2, 0, 6, 6 };

		String ans = largestTimeFromDigits(nums);

		System.out.println(ans);

	}

}
