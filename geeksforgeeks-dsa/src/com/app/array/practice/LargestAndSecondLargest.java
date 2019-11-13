package com.app.array.practice;

public class LargestAndSecondLargest {
	private static void largestAndSecondLargest(int[] arr) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (largest < arr[i]) {
				secondLargest = largest;
				largest = arr[i];
			}
			if (arr[i] > secondLargest && arr[i] != largest) {
				secondLargest = arr[i];
			}
		}

		if (secondLargest == Integer.MIN_VALUE) {
			secondLargest = -1;
		}
		System.out.println(largest + " " + secondLargest);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		largestAndSecondLargest(arr);
	}

}
