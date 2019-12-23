package com.app.hashing.practice;

import java.util.HashMap;
import java.util.Map;

public class CountDistinct {
	private static int countDistinct(int[] arr) {
		int n = arr.length;

		int count = 0;
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!numMap.containsKey(arr[i])) {
				numMap.put(arr[i], 1);
			} else {
				int tmp = numMap.get(arr[i]);
				numMap.put(arr[i], ++tmp);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry: numMap.entrySet()) {
			int val = entry.getValue();
			if(val == 1)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 10, 40 };
		System.out.println("Count Distinct - " + countDistinct(arr));

	}

}
