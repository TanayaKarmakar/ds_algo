package com.app.searching.classroom;

public class LeftMostIndex {
	private static int findLeftMostIndx(int[] arr, int x) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if(arr[mid] == x && (mid == 0 || arr[mid - 1] != x))
				return mid;
			else if(arr[mid] >= x)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Leftmost Index - " + findLeftMostIndx(new int[] { 2, 3, 3, 3, 5 }, 3));

		int[] arr = { 2, 3, 3, 3, 4, 4, 5, 5, 7, 9, 10, 11 };
		System.out.println("Leftmost Index of 4- " + findLeftMostIndx(arr, 4));
		System.out.println("Leftmost Index of 5- " + findLeftMostIndx(arr, 5));
		System.out.println("Leftmost Index of 7- " + findLeftMostIndx(arr, 7));
		System.out.println("Leftmost Index of 2- " + findLeftMostIndx(arr, 2));
		System.out.println("Leftmost Index of 11- " + findLeftMostIndx(arr, 11));
		System.out.println("Leftmost Index of 10- " + findLeftMostIndx(arr, 10));
		System.out.println("Leftmost Index of 9- " + findLeftMostIndx(arr, 9));
	}

}
