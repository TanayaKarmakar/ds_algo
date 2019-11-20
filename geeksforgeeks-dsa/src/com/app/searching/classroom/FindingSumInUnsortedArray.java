package com.app.searching.classroom;

import java.util.HashSet;
import java.util.Set;

public class FindingSumInUnsortedArray {
	private static void sumInUnsortedArray(int[] arr, int x) {
		int n = arr.length;

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (set.contains(x - arr[i])) {
				System.out.println(arr[i] + " " + (x - arr[i]));
			}
			set.add(arr[i]);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 5, 9, 2, 8, 10, 11 };

		sumInUnsortedArray(arr, 17);

	}

}
