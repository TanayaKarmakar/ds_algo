package com.app.hashing.classroom;

import java.util.LinkedHashSet;
import java.util.Set;

public class CountDistinctElements {
	private static void countDistinctElements(int[] arr) {
		Set<Integer> set = new LinkedHashSet<>();

		int n = arr.length;
		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}

		System.out.println(set);

		System.out.println("Number of distinct elements - " + set.size());
	}

	public static void main(String[] args) {
		int[] arr = { 12, 13, 15, 13, 18, 15, 15, 18, 20 };
		countDistinctElements(arr);

	}

}
