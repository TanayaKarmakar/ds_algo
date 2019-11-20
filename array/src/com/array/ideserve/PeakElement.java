package com.array.ideserve;

public class PeakElement {
	private static int peakElement(int[] arr, int start, int end) {

		int mid = (start + end) / 2;
		if (isGreaterOrEqual(arr, mid))
			return arr[mid];
		else {
			if (mid > 0 && arr[mid] < arr[mid - 1]) {
				end = mid - 1;
			} else if (arr[mid] < arr[mid + 1]) {
				start = mid + 1;
			}
			return peakElement(arr, start, end);
		}

	}

	private static boolean isGreaterOrEqual(int[] arr, int index) {
		if (index == 0) {
			return arr[index] >= arr[index + 1];
		} else if (index == arr.length - 1) {
			return arr[index] >= arr[index - 1];
		} else {
			return ((arr[index] >= arr[index - 1]) && (arr[index] >= arr[index + 1]));
		}
	}

	public static void main(String[] args) {
		int[] arr = { 40, 10, 20, 5, 45, 50, 65, 90, 35, 25 };
		System.out.println("Peak Element - " + peakElement(arr, 0, arr.length - 1));

		arr = new int[] { 4, 7, 5, 2, 1 };
		System.out.println("Peak Element - " + peakElement(arr, 0, arr.length - 1));

		arr = new int[] { 1, 2, 3, 4, 6 };
		System.out.println("Peak Element - " + peakElement(arr, 0, arr.length - 1));
		
		arr = new int[]{ 20, 30, 5, 18, 19, 15 };
		System.out.println("PeakElement " + peakElement(arr, 0, arr.length - 1));
	}

}
