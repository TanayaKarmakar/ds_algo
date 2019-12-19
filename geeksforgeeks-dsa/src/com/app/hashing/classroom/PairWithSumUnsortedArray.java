package com.app.hashing.classroom;

import java.util.HashSet;
import java.util.Set;

public class PairWithSumUnsortedArray {
	private static boolean pairWithSum(int[] arr, int sum) {
		int n = arr.length;

		Set<Integer> numSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (numSet.contains(sum - arr[i])) {
				return true;
			} else {
				numSet.add(arr[i]);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 8, 15, -8 };
		System.out.println("PairWithSum - " + pairWithSum(arr, 17));
		System.out.println("PairWithSum - " + pairWithSum(arr, 12));

		arr = new int[] { 11, 5, 6 };
		System.out.println("PairWithSum - " + pairWithSum(arr, 10));

	}

}
