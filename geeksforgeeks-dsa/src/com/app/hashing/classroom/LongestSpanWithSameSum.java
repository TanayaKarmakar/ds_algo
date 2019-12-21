package com.app.hashing.classroom;

import java.util.HashMap;
import java.util.Map;

// Given two binary arrays arr1[] and arr2[] of same size n. 
// Find length of the longest common span (i, j) where j >= i such 
// that arr1[i] + arr1[i+1] + …. + arr1[j] = arr2[i] + arr2[i+1] + …. + arr2[j].
public class LongestSpanWithSameSum {
	private static int longestSpan(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = arr1[i] - arr2[i];
		}

		int preSum = 0;
		int res = 0;
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			preSum += arr[i];
			if (preSum == 0) {
				res = i + 1;
			}
			if (!numMap.containsKey(preSum)) {
				numMap.put(preSum, i);
			}
			if (numMap.containsKey(preSum)) {
				res = Integer.max(res, i - numMap.get(preSum));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr1 = { 0, 1, 0, 0, 0, 0 };
		int[] arr2 = { 1, 0, 1, 0, 0, 1 };
		System.out.println("Length - " + longestSpan(arr1, arr2));

		arr1 = new int[] { 0, 1, 0, 1, 1, 1, 1 };
		arr2 = new int[] { 1, 1, 1, 1, 1, 0, 1 };
		System.out.println("Length - " + longestSpan(arr1, arr2));

		arr1 = new int[] { 0, 0, 0 };
		arr2 = new int[] { 1, 1, 1 };
		System.out.println("Length - " + longestSpan(arr1, arr2));

		arr1 = new int[] { 0, 0, 1, 0 };
		arr2 = new int[] { 1, 1, 1, 1 };
		System.out.println("Length - " + longestSpan(arr1, arr2));

	}

}
