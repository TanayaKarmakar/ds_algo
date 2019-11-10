package com.array.ideserve;

public class PivotInSortedRotatedArray {
	private static int findPivot(int[] arr) {
		if (arr.length == 0 || arr == null)
			return -1;
		else if (arr.length == 1)
			return arr[0];
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] > arr[mid + 1]) {
				return (mid + 1);
			} else {
				if (arr[start] <= arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 73, 85, 94, 21, 27, 34, 47, 54, 66 };
		int pivotIndx = findPivot(arr);
		
		if(pivotIndx != -1) {
			if(pivotIndx == 0) {
				System.out.println("Array is sorted");
			} else {
				System.out.println(arr[pivotIndx]);
			}
		}
	}

}
