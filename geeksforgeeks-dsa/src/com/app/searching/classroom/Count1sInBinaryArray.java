package com.app.searching.classroom;

public class Count1sInBinaryArray {
	private static int findNumberOf1s(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		int startIndx = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == 1) {
				if (mid == 0 || arr[mid - 1] != 1) {
					startIndx = mid;
					break;
				} else {
					high = mid - 1;
				}
			} else {
				low = mid + 1;
			}
		}

		return (arr.length - startIndx);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 1, 1, 1, 1, 1 };
		System.out.println("Occurences of 1 - " + findNumberOf1s(arr));

		arr = new int[] { 0, 0, 0, 0, 0, 1, 1, 1 };
		System.out.println("Occurences of 1 - " + findNumberOf1s(arr));
	}

}
