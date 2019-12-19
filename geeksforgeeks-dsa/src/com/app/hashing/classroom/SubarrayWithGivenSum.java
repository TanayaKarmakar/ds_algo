package com.app.hashing.classroom;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithGivenSum {
	private static boolean subArrayWithSum(int[] arr, int sum) {
		int n = arr.length;
		int preSum = 0;
		Set<Integer> numSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			preSum += arr[i];
			if (preSum == sum)
				return true;
			if (numSet.contains(preSum - sum))
				return true;
			numSet.add(preSum);
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 8, 6, 13, 3, -1 };
		System.out.println(subArrayWithSum(arr, 22));

		arr = new int[] { 12, 5, 10, -7, -6, 6 };
		System.out.println(subArrayWithSum(arr, 3));

	}

}
