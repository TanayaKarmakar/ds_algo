package com.app.companywise.microsoft;

import java.util.HashMap;
import java.util.Map;

public class NumbersWithEqualDigitSum {
	private static int findSumOfDigits(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}

	private static int findMaxSum(int[] arr) {
		int n = arr.length;
		Map<Integer, Integer> numMap = new HashMap<>();
		int maxSum = -1;
		for (int i = 0; i < n; i++) {
			int sum = findSumOfDigits(arr[i]);

			if(!numMap.containsKey(sum)) {
				numMap.put(sum, arr[i]);
			} else {
				maxSum = Integer.max(maxSum, numMap.get(sum) + arr[i]);
				numMap.put(sum, Integer.max(arr[i], numMap.get(sum)));
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = { 51, 71, 17, 42 };

		System.out.println(findMaxSum(arr));

		arr = new int[] { 42, 33, 60 };

		System.out.println(findMaxSum(arr));

	}

}
