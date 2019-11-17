package com.app.searching.classroom;

public class RightMostIndex {
	private static int findRightMostIndex(int[] arr, int x) {
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			int mid = low + (high - low)/2;
			if(arr[mid] == x && (mid == arr.length - 1 || arr[mid + 1] > x))
				return mid; 
			else if(arr[mid] > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) { 
		//System.out.println("Rightmost Index of 3- " + findRightMostIndex(new int[] { 2, 3, 3, 3, 3, 5 }, 3));

		int[] arr = { 2, 2, 3, 3, 3, 4, 4, 5, 5, 7, 9, 10, 11, 11 };
		System.out.println("Rightmost Index of 4- " + findRightMostIndex(arr, 4));
		System.out.println("Rightmost Index of 5- " + findRightMostIndex(arr, 5));
		System.out.println("Rightmost Index of 7- " + findRightMostIndex(arr, 7));
		System.out.println("Rightmost Index of 2- " + findRightMostIndex(arr, 2));
		System.out.println("Rightmost Index of 11- " + findRightMostIndex(arr, 11));
		System.out.println("Rightmost Index of 10- " + findRightMostIndex(arr, 10));
		System.out.println("Rightmost Index of 9- " + findRightMostIndex(arr, 9));
	}

}
