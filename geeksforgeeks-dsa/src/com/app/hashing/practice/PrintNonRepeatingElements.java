package com.app.hashing.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrintNonRepeatingElements {
	private static void printNonRepeatingElements(int[] arr) {
		int n = arr.length;
		Map<Integer, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < n; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				int tmp = map.get(arr[i]);
				map.put(arr[i], ++tmp);
			}
		}

		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			int val = entry.getValue();
			if(val == 1) {
				System.out.print(entry.getKey() + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {1,1,2,2,3,3,4,5,6,7};
		
		printNonRepeatingElements(arr);
		
		arr = new int[] {10,20,30,40,10};
		
		printNonRepeatingElements(arr);
	}
}
