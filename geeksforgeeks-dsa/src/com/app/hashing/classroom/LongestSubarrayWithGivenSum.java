package com.app.hashing.classroom;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithGivenSum {
	private static int longestSubarrayWithGivenSum(int[] arr, int sum) {
		int n = arr.length;
		Map<Integer, Integer> numMap = new HashMap<>();
		int preSum = 0;
		int res = 0;
		for (int i = 0; i < n; i++) {
			preSum += arr[i];
			if (preSum == sum) {
				res = i + 1;
			}
			if (!numMap.containsKey(preSum)) {
				numMap.put(preSum, i);
			}
			if (numMap.containsKey(preSum - sum)) {
				res = Integer.max(res, i - numMap.get(preSum - sum));
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 8, -4, -4, 9, -2, 2 };

		System.out.println(longestSubarrayWithGivenSum(arr, 0));

		arr = new int[] { 3, 1, 0, 1, 8, 2, 3, 6 };
		System.out.println(longestSubarrayWithGivenSum(arr, 5));

		arr = new int[] { 8, 3, 1, 5, -6, 6, 2, 2 };
		System.out.println(longestSubarrayWithGivenSum(arr, 4));
	}

}
