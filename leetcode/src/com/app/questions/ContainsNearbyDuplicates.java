package com.app.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsNearbyDuplicates {
	private static boolean containsNearbyDuplicateEfficient(int[] arr, int k) {
		if (arr == null || arr.length <= 1 || k <= 0)
			return false;

		int start = 0;
		int end = 0;
		while (start < arr.length - 1) {
			if (start != end && arr[start] == arr[end])
				return true;
			else {
				if ((end - start) == k || end == arr.length - 1) {
					start++;
					end = start + 1;
				} else {
					end++;
				}
			}
		}
		return false;
	}

	private static boolean containsNearbyDuplicate(int[] arr, int k) {
		if (arr.length <= 1)
			return false;
		Map<Integer, List<Integer>> numMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!numMap.containsKey(arr[i])) {
				List<Integer> indexList = new ArrayList<>();
				indexList.add(i);
				numMap.put(arr[i], indexList);
			} else {
				int prevNum = numMap.get(arr[i]).get(numMap.get(arr[i]).size() - 1);
				if (i - prevNum <= k)
					return true;
				numMap.get(arr[i]).add(i);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1 };

		System.out.println(containsNearbyDuplicate(arr, 3));
		
		System.out.println(containsNearbyDuplicateEfficient(arr, 3));

		arr = new int[] { 1, 0, 1, 1 };

		System.out.println(containsNearbyDuplicate(arr, 1));
		
		System.out.println(containsNearbyDuplicateEfficient(arr, 1));

		arr = new int[] { 1, 2, 3, 1, 2, 3 };

		System.out.println(containsNearbyDuplicate(arr, 2));
		
		System.out.println(containsNearbyDuplicateEfficient(arr, 2));
	}

}
