package com.app.array.practice;

public class SmallestPositiveNumber {
	private static void missingSmallestPositive(int[] arr) {
		int i = -1;
		int n = arr.length;
		int tmp = 0;
		for (int j = 0; j < n; j++) {
			if (arr[j] > 0) {
				i++;
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}

	//	System.out.println(Arrays.toString(arr));
		for (int j = 0; j < (i + 1); i++) {
			int k = Math.abs(arr[j]) - 1;
			if(k < n && arr[k] > 0) {
				arr[k] = -arr[k];
			}
		}
	//	System.out.println(Arrays.toString(arr));

		for (int j = 0; j < n; j++) {
			if (arr[j] > 0) {
				System.out.println("Smallest missing positive number - " + (j + 1));
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 0, -10, 1, 3, -20 };
		missingSmallestPositive(arr);
	}
}
