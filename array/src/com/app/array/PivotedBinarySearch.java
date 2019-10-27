package com.app.array;

public class PivotedBinarySearch {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 1, 2, 3 };
		int indx  = pivotedBinarySearch(arr, arr.length - 1, 5);
		System.out.println("Pivoted Search - " + indx);

	}

	private static int pivotedBinarySearch(int[] arr, int n, int key) {
		int pivot = findPivot(arr, 0, n);

		if (arr[pivot] == key)
			return pivot;
		if (arr[0] <= key)
			return binarySearch(arr, 0, pivot - 1, key);
		else
			return binarySearch(arr, pivot + 1, n, key);

	}

	private static int binarySearch(int[] arr, int low, int high, int key) {
		if (high < low)
			return -1;
		int mid = (low + high) / 2;
		if (arr[mid] == key)
			return mid;
		else if (arr[mid] > key)
			return binarySearch(arr, low, mid - 1, key);
		else
			return binarySearch(arr, mid + 1, high, key);
	}

	private static int findPivot(int[] arr, int low, int high) {
		if (high < low) {
			return -1;
		}
		if (low == high)
			return low;
		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1]) {
			return mid;
		}
		if (mid > low && arr[mid] < arr[mid - 1]) {
			return (mid - 1);
		}
		if (arr[low] <= arr[mid]) {
			return findPivot(arr, low, mid - 1);
		} else {
			return findPivot(arr, mid + 1, high);
		}

	}

}
