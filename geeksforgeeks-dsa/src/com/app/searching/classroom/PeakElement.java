package com.app.searching.classroom;

public class PeakElement {
	private static int peakElement(int[] arr, int start, int end) {
		int mid = (start + end)/2;
		if (isGreaterOrEqual(arr, mid))
			return mid;
		else {
			if (mid > 0 && arr[mid - 1] > arr[mid])
				end = mid - 1;
			else if (arr[mid + 1] > arr[mid])
				start = mid + 1;
			return peakElement(arr, start, end);
		}
	}

	private static boolean isGreaterOrEqual(int[] arr, int indx) {
		if (indx == 0) {
			return arr[indx] >= arr[indx + 1];
		} else if (indx == arr.length - 1) {
			return arr[indx] >= arr[indx - 1];
		} else {
			return ((arr[indx] >= arr[indx - 1]) && (arr[indx] >= arr[indx + 1]));
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 20, 30, 5, 18, 19, 15 };
		System.out.println("PeakElement " + arr[peakElement(arr, 0, arr.length - 1)]);
	}

}
