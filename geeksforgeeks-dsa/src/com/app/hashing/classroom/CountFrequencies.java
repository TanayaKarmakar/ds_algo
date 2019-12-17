package com.app.hashing.classroom;

import java.util.HashMap;
import java.util.Map;

public class CountFrequencies {
	private static void countFreq(int[] arr) {
		int n = arr.length;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				int tmp = map.get(arr[i]);
				map.put(arr[i], ++tmp);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 10, 15, 10, 20, 12, 12 };
		countFreq(arr);
	}

}
