package com.app.array.practice;

import java.util.Arrays;

public class FrequencyOfInteger {
	private static void frequency(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] - 1;
		}

		for (int i = 0; i < n; i++) {
			arr[arr[i] % n] += n;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] / n + "\t");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		frequency(new int[] { 2, 3, 2, 3, 5 });
		frequency(new int[] { 3, 3, 3, 3 });
	}

}
