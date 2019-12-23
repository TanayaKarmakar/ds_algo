package com.app.hashing.practice;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarrayWithSum {
	private static int subArraySum(int[] arr, int sum) {
		int n = arr.length;

		int res = 0;
		int preSum = 0;

		Map<Integer, Integer> preSumMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			preSum += arr[i];

			if (preSum == sum)
				res++;

			if (preSumMap.containsKey(preSum - sum)) {
				res += preSumMap.get(preSum - sum);
			}

			Integer count = preSumMap.get(preSum);
			if (count == null) {
				preSumMap.put(preSum, 1);
			} else {
				preSumMap.put(preSum, count + 1);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 2, -2, -20, 10 };

		System.out.println("Count - " + subArraySum(arr, -10));

	}

}
