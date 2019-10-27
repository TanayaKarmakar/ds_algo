package com.app.array;

public class MinimumElementInSortedRotatedArray {
	private static int findPivot(int[] arr, int low, int high) {
		if (high < low)
			return -1;
		if (low == high)
			return low;
		int mid = (low + high) / 2;

		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[0] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);

	}
	
	private static int findMinIndex(int[] arr) {
		int pivotIndx = findPivot(arr, 0, arr.length - 1);
		if(pivotIndx == arr.length - 1) //array is not rotated at all
			return 0;
		return (pivotIndx + 1);
	}

	public static void main(String[] args) {
		int[] arr = { 5, 6, 1, 2, 3, 4 };
		int minIndx = findMinIndex(arr);
		System.out.println("Minimum element - " + arr[minIndx]);
		
		arr = new int[]{1, 2, 3, 4};
		minIndx = findMinIndex(arr);
		System.out.println("Minimum element - " + arr[minIndx]);
		
	}

}
