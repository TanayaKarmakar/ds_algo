package com.app.searching.practice;

public class FloorInSortedArray {
	private static int floorInSortedArray(int[] arr, int x) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] <= x && (mid == arr.length - 1 || arr[mid + 1] > x))
				return mid;
			else if (arr[mid] > x)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 8, 10, 11, 12, 19 };
		System.out.println("Floor " + floorInSortedArray(arr, 0));
		System.out.println("Floor " + floorInSortedArray(arr, 5));
		System.out.println("Floor " + floorInSortedArray(arr, 10));

	}

}
