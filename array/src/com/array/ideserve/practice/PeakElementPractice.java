package com.array.ideserve.practice;

public class PeakElementPractice {
	private static int findPeakElement(int[] arr, int start, int end) {
		if (arr.length == 0 || start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (isGreaterOrEqual(arr, mid)) {
			return arr[mid];
		} else if ((mid - 1) >= 0 && arr[mid] < arr[mid - 1]) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
		return findPeakElement(arr, start, end);
	}

	private static boolean isGreaterOrEqual(int[] arr, int indx) {
		if (indx == 0) {
			return arr[indx] >= arr[indx + 1];
		} else if (indx == arr.length - 1) {
			return arr[indx] >= arr[indx - 1];
		} else {
			return (arr[indx] >= arr[indx - 1] && arr[indx] >= arr[indx + 1]);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 40, 10, 20, 5, 45, 50, 65, 90, 35, 25 };
		System.out.println("Peak Element - " + findPeakElement(arr, 0, arr.length - 1));

		arr = new int[] { 4, 7, 5, 2, 1 };
		System.out.println("Peak Element - " + findPeakElement(arr, 0, arr.length - 1));

		arr = new int[] { 1, 2, 3, 4, 6 };
		System.out.println("Peak Element - " + findPeakElement(arr, 0, arr.length - 1));
	}

}
