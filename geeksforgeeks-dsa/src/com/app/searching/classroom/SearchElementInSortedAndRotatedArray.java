package com.app.searching.classroom;

public class SearchElementInSortedAndRotatedArray {
	private static int findPivot(int[] arr) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid + 1 < arr.length && arr[mid] > arr[mid + 1])
				return mid;
			else if (mid - 1 >= 0 && arr[mid] < arr[mid - 1])
				return mid - 1;
			else {
				if (arr[low] <= arr[mid])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}

		return -1;
	}

	private static int binarySearch(int[] arr, int start, int end, int x) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == x)
				return mid;
			else if (arr[mid] > x)
				end = mid - 1;
			else
				start = mid + 1;
		}

		return -1;
	}

	private static int searchElement(int[] arr, int x) {
		int pivotIndx = findPivot(arr);
		if (pivotIndx == -1) {
			// array is sorted
			// normal binary search will work
			return binarySearch(arr, 0, arr.length - 1, x);
		} else if (x >= arr[0] && x <= arr[pivotIndx]) {
			// do binary search within start and pivotIndx
			return binarySearch(arr, 0, pivotIndx, x);
		} else {
			// do binary search within pivotIndx + 1 and arr.length -1
			return binarySearch(arr, pivotIndx + 1, arr.length - 1, x);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 10, 20, 40, 5, 6, 7, 8 };

		System.out.println("Index of 20 is " + searchElement(arr, 20));

		arr = new int[] { 20, 30, 40, 50, 70, 80, 10 };
		System.out.println("Index of 10 is " + searchElement(arr, 10));
	}

}
