package com.array.ideserve;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
	private static int findLCS(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int n = arr.length;
		int maxLen = 0;

		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}

		int i = 0;
		while (i < n) {
			if (!set.contains(arr[i] - 1)) {
				int j = arr[i];
				while (set.contains(j)) {
					j++;
				}
				if (maxLen < (j - arr[i])) {
					maxLen = j - arr[i];
				}
			}
			i++;
		}

		return maxLen;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, 3, 10, 4, 20, 2 };
		System.out.println("Longest Consecutive Subsequence - " + findLCS(arr));
	}

}
