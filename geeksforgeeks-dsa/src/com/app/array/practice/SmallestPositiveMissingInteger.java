package com.app.array.practice;

public class SmallestPositiveMissingInteger {
	private static int smallestPositiveMissingNumber(int[] arr) {
		int n = arr.length;
		int i = -1;
		int tmp = 0;

		for (int j = 0; j < n; j++) {
			if (arr[j] > 0) {
				i++;
				tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
		}

		// System.out.println(Arrays.toString(arr));
		for (int j = 0; j < (i + 1); j++) {
			int k = Math.abs(arr[j]);
			if ((k - 1) < n && arr[k - 1] > 0) {
				arr[k - 1] = -arr[k - 1];
			}
		}

		for (i = 0; i < n; i++) {
			if (arr[i] > 0)
				return (i + 1);
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 0, -10, 1, 3, -20 };
		System.out.println(smallestPositiveMissingNumber(arr));
	}

}
