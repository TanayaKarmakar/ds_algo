package com.app.questions;

public class FindMinInSortedRotatedArray {
	private static int findMin(int[] arr) {
		if (arr.length == 0)
			return -1;
		if (arr.length == 1)
			return 0;
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (mid > 0 && arr[mid - 1] > arr[mid]) {
				return mid;
			} else if (mid + 1 < arr.length && arr[mid] > arr[mid + 1])
				return mid + 1;
			else if (arr[low] <= arr[mid])
				low = mid + 1;
			else
				high = mid - 1;

		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
		int indx = findMin(arr);
		if(indx == -1)
			System.out.println(arr[0]);
		else
			System.out.println(arr[indx]);
	}

}
