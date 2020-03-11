package com.app.languagetools1.problems;

import java.util.HashMap;
import java.util.Map;

public class UniqueElement {
	private static int findUnique(int[] arr) {
		Map<Integer, Integer> freMap = new HashMap<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (!freMap.containsKey(arr[i])) {
				freMap.put(arr[i], 1);
			} else {
				int tmp = freMap.get(arr[i]);
				freMap.put(arr[i], ++tmp);
			}
		}

		for (Map.Entry<Integer, Integer> entry : freMap.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 6, 3, 6, 2 };
		
		System.out.println(findUnique(nums));

	}

}
