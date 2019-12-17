package com.app.hashing.classroom;

import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoUnsortedArray {
	private static void countDistinct(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;

		Set<Integer> numSet1 = new HashSet<>();
		Set<Integer> numSet2 = new HashSet<>();

		for (int i = 0; i < n; i++) {
			numSet1.add(arr1[i]);
		}

		for (int j = 0; j < m; j++) {
			numSet1.add(arr2[j]);
		}

//		int cnt = 0;
//		for (Integer el : numSet1) {
//			if (numSet2.contains(el)) {
//				cnt++;
//			}
//		}
//
//		cnt = numSet1.size() + numSet2.size() - cnt;
		System.out.println(numSet1.size());
	}

	public static void main(String[] args) {
		int[] arr1 = { 10, 15, 5, 15 };
		int[] arr2 = { 15, 15, 15, 20, 10 };

		countDistinct(arr1, arr2);

	}

}
