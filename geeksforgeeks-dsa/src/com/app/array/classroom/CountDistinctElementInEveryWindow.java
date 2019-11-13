package com.app.array.classroom;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementInEveryWindow {
	private static void countDistinctElement(int[] arr, int windowSize) {
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		int start = 0;
		while (i < windowSize) {
			addData(map, arr[i]);
			i++;
		}

		while (i < arr.length) {
			System.out.print(map.size() + "\t");
			updateOrRemove(map, arr[start]);
			addData(map, arr[i]);
			i++;
			start++;
		}
		// printing the last element
		System.out.print(map.size() + "\t");
		System.out.println();
	}

	private static void updateOrRemove(Map<Integer, Integer> map, int num) {
		int tmp = map.get(num);
		tmp = tmp - 1;
		if (tmp == 0) {
			map.remove(num);
		} else {
			map.put(num, tmp);
		}
	}

	private static void addData(Map<Integer, Integer> map, int num) {
		if (!map.containsKey(num)) {
			map.put(num, 1);
		} else {
			int count = map.get(num);
			map.put(num, ++count);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 4, 3, 3 };
		countDistinctElement(arr, 4);

		arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		countDistinctElement(arr, 3);
	}

}
