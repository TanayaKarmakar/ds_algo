package com.app.hashing.classroom;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithZeroSum {
	private static boolean subArrayZeroSum(int[] arr) {
		int n = arr.length;
		int preSum = 0;
		Set<Integer> numSet = new HashSet<>();

		for (int i = 0; i < n; i++) {
			preSum = preSum + arr[i];
			if (numSet.contains(preSum)) {
				return true;
			}
			if (preSum == 0)
				return true;
			numSet.add(preSum);
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 13, -3, -10, 5 };
		System.out.println(subArrayZeroSum(arr));

		arr = new int[] { 3, -1, -4, 6, 9, -5 };
		System.out.println(subArrayZeroSum(arr));

	}

}
