package com.app.questions;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	private static boolean hasDuplicate(int[] arr) {
		if (arr.length <= 1)
			return false;
		Set<Integer> numSet = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (numSet.contains(arr[i]))
				return true;
			numSet.add(arr[i]);
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1 };
		System.out.println(hasDuplicate(arr));

		arr = new int[] { 1, 2, 3, 4 };
		System.out.println(hasDuplicate(arr));

	}

}
