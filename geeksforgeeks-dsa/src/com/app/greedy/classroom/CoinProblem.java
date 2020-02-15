package com.app.greedy.classroom;

import java.util.Arrays;
import java.util.Collections;

public class CoinProblem {
	private static int getCount(Integer[] arr, int amount) {
		Arrays.sort(arr, Collections.reverseOrder());
		int n = arr.length;
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (amount / arr[i] > 0) {
				int c = amount / arr[i];
				res = res + c;
				amount = amount - (c * arr[i]);
			}

			if (amount == 0)
				break;
		}
		return res;
	}

	public static void main(String[] args) {
		Integer[] arr = { 5, 10, 2, 1 };

		System.out.println(getCount(arr, 57));

	}

}
