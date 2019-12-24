package com.app.hashing.practice;

import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSubsequence {
	private static int longestConsecutiveSubSequence(int[] arr) {
		Set<Integer> numSet = new TreeSet<>();
		// int minVal = Integer.MAX_VALUE;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			numSet.add(arr[i]);
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			if (!numSet.contains(arr[i] - 1)) {
				int j = arr[i];
				while (numSet.contains(j)) {
					j++;
				}
				res = Integer.max(res, j - arr[i]);
			}
		}

		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
		System.out.println(longestConsecutiveSubSequence(arr));

		arr = new int[] { 1, 9, 3, 10, 4, 20, 2 };
		System.out.println(longestConsecutiveSubSequence(arr));
	}

}
