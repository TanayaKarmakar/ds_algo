package com.app.hashing.classroom;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
	private static void findIntersection(int[] arr1, int[] arr2) {
		Set<Integer> numSet1 = new HashSet<>();
		int n = arr1.length;
		for (int i = 0; i < n; i++) {
			numSet1.add(arr1[i]);
		}

		int m = arr2.length;
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			if (numSet1.contains(arr2[i])) {
				cnt++;
				numSet1.remove(arr2[i]);
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		int[] arr1 = { 10, 20, 30, 5, 60, 40, 30 };
		int[] arr2 = { 10, 30, 40, 5, 30 };

		findIntersection(arr1, arr2);

		arr1 = new int[] { 10, 10, 10 };
		arr2 = new int[] { 10, 10, 10 };

		findIntersection(arr1, arr2);
	}

}
