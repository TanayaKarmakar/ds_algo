package com.app.sorting.practice;

import java.util.Arrays;

public class CountInversions {
	private static int countInvAndMerge(int[] arr, int low, int mid, int high) {
		int n1 = (mid - low) + 1;
		int n2 = (high - mid);

		int[] part1 = new int[n1];
		int[] part2 = new int[n2];

		int i = 0;
		int j = 0;
		int k = 0;

		int res = 0;

		for (i = low; i <= mid; i++) {
			part1[k++] = arr[i];
		}

		k = 0;
		for (i = mid + 1; i <= high; i++) {
			part2[k++] = arr[i];
		}

		k = low;
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

	private static int countInv(int[] arr, int low, int high) {
		int res = 0;
		if (low < high) {
			int mid = low + (high - low) / 2;
			res += countInv(arr, low, mid);
			res += countInv(arr, mid + 1, high);
			res += countInvAndMerge(arr, low, mid, high);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 1, 3, 5 };
		
		int res = countInv(arr, 0, arr.length - 1);
		
		System.out.println("Number of inversions - " + res);
		
		System.out.println("After sorting, the array is ");
		System.out.println(Arrays.toString(arr));

	}

}
