package com.app.hashing.practice;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithZeroSum {
	private static boolean isSubArrayExists(int[] arr) {
		Set<Integer> numSet = new HashSet<>();

		int preSum = 0;
		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];
			if (preSum == 0)
				return true;
			else if (numSet.contains(preSum))
				return true;
			else
				numSet.add(preSum);
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, -3, 1, 6 };

		System.out.println("Zero sum subarray - " + isSubArrayExists(arr));

	}

}
