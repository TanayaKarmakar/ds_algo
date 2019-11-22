package com.app.searching.practice;

public class PivotInSortedRotatedArray {
	private static int findPivot(int[] arr) {
		int low = 0;
		int high = arr.length - 1;

		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if ((mid - 1) >= 0 && arr[mid] < arr[mid - 1])
				return arr[mid];
			else if (mid + 1 < arr.length && arr[mid] > arr[mid + 1])
				return arr[mid + 1];
			else {
				if (arr[low] <= arr[mid])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		return arr[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Find Pivot " + findPivot(new int[] {2,3,4,5,6,7,8,9,10,1}));
		System.out.println("Find Pivot " + findPivot(new int[] {2,3,4,5,6,7,8,9,10,1}));
	}

}
