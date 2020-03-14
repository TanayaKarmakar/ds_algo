package com.app.searchsort.problems;

public class InversionCount {
	private static long merge(int[] arr, int low, int mid, int high) {
		int n1 = (mid - low + 1);
		int n2 = (high - mid);
		int[] l1 = new int[n1];
		int[] l2 = new int[n2];

		int k = 0;
		for (int i = low; i <= mid; i++) {
			l1[k++] = arr[i];
		}

		k = 0;
		for (int i = mid + 1; i <= high; i++) {
			l2[k++] = arr[i];
		}

		int i = 0;
		int j = 0;
		long invCount = 0;
		k = low;
		while (i < n1 && j < n2) {
			if (l1[i] > l2[j]) {
				invCount += (n1 - i);
				arr[k++] = l2[j++];
			} else {
				arr[k++] = l1[i++];
			}
		}

		while (i < n1) {
			arr[k++] = l1[i++];
		}

		while (j < n2) {
			arr[k++] = l2[j++];
		}

		return invCount;
	}
//	private static int merge(int[] arr, int low, int mid, int high) {
//		int[] tmp = new int[high - low + 1];
//		int i = low;
//		int j = mid;
//		int k = 0;
//		int invCount = 0;
//
//		while (i < mid && j <= high) {
//			if (arr[i] <= arr[j]) {
//				tmp[k++] = arr[i++];
//			} else {
//				tmp[k++] = arr[j++];
//				invCount += (mid - i);
//			}
//		}
//
//		while (i < mid) {
//			tmp[k++] = arr[i++];
//		}
//
//		while (j <= high) {
//			tmp[k++] = arr[j++];
//		}
//
//		for (i = 0, k = low; k<=high; i++, k++) {
//			arr[k] = tmp[i];
//		}
//
//		return invCount;
//	}

	private static long mergeSort(int[] arr, int low, int high) {
		long count = 0;
		if (low < high) {
			int mid = low + (high - low) / 2;
			long lCount = mergeSort(arr, low, mid);
			long rCount = mergeSort(arr, mid + 1, high);
			long mCount = merge(arr, low, mid, high);
			return (lCount + rCount + mCount);
		}
		return count;
	}

	private static long solve(int[] arr, int n) {
		return mergeSort(arr, 0, n - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1 };

		System.out.println("Inversion Count - " + solve(arr, arr.length));

		arr = new int[] { 2, 5, 1, 3, 4 };

		System.out.println("Inversion Count - " + solve(arr, arr.length));

	}

}
