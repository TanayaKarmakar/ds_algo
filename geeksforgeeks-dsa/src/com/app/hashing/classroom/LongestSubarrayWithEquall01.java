package com.app.hashing.classroom;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEquall01 {
	private static int longestSubarray(int[] arr) {
		int n = arr.length;
		int preSum = 0;
		int res = 0;
		Map<Integer, Integer> numMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				preSum -= 1;
			} else {
				preSum += arr[i];
			}
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
		int[] arr = { 1, 0, 1, 1, 1, 0, 0 };
		System.out.println("Longest Subarray - " + longestSubarray(arr));

		arr = new int[] { 1, 1, 1, 1 };
		System.out.println("Longest Subarray - " + longestSubarray(arr));

		arr = new int[] { 0, 0, 1, 1, 1, 1, 1, 0 };
		System.out.println("Longest Subarray - " + longestSubarray(arr));
	}

}
