package com.app.sorting.practice;

public class CloserToSort {
	private static int closerToSort(int[] arr, int n, int x) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int indx = checkIndexAroundMid(arr, mid, x);
			if (indx > -1)
				return indx;
			else if (arr[mid] > x)
				high = mid - 2;
			else
				low = mid + 2;
		}

		return -1;
	}

	private static int checkIndexAroundMid(int[] arr, int mid, int x) {
		if (arr[mid] == x)
			return mid;
		else if (mid > 0 && arr[mid - 1] == x)
			return (mid - 1);
		else if ((mid + 1) < arr.length && arr[mid + 1] == x)
			return (mid + 1);
		else
			return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 10, 4, 40 };

		System.out.println(closerToSort(arr, 5, 2));

		arr = new int[] { 2, 1, 4, 3 };

		System.out.println(closerToSort(arr, 4, 5));
	}

}
