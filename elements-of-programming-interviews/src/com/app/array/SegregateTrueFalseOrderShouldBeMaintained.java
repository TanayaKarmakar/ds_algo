package com.app.array;

import java.util.Arrays;

public class SegregateTrueFalseOrderShouldBeMaintained {
	private static void segregateTrueFalse(boolean[] arr) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == false)
				count++;
		}

		for (int i = 0; i < count; i++) {
			arr[i] = false;
			arr[i + count] = true;
		}
	}

	public static void main(String[] args) {
		boolean[] arr = { true, false, false, true, true, false, true, false };
		segregateTrueFalse(arr);

		System.out.println(Arrays.toString(arr));

	}

}
