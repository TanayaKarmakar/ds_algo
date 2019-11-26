package com.app.sorting.classroom;

public class CountInversionsOfArray {

	private static int countInvAndMerge(int[] arr, int left, int mid, int right) {
		int n1 = (mid - left) + 1;
		int n2 = (right - mid);
		int[] part1 = new int[n1];
		int[] part2 = new int[n2];

		int i = 0;
		int j = 0;
		int k = 0;

		int res = 0;

		for (i = left; i <= mid; i++) {
			part1[k++] = arr[i];
		}

		k = 0;
		for (i = mid + 1; i <= right; i++) {
			part2[k++] = arr[i];
		}

		k = left;
		i = 0;
		j = 0;
		while (i < n1 && j < n2) {
			if (part1[i] <= part2[j]) {
				arr[k++] = part1[i++];
			} else {
				arr[k++] = part2[j++];
				res += (n1 - i);
			}
		}

		while (i < n1) {
			arr[k++] = part1[i++];
		}

		while (j < n2) {
			arr[k++] = part2[j++];
		}

		return res;
	}

	private static int countInversion(int[] arr, int left, int right) {
		int res = 0;
		if (left < right) {
			int mid = left + (right - left) / 2;
			res += countInversion(arr, left, mid);
			res += countInversion(arr, mid + 1, right);
			res += countInvAndMerge(arr, left, mid, right);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 1, 3, 5 };
		System.out.println("Number of inversions - " + countInversion(arr, 0, arr.length - 1));
	}

}
