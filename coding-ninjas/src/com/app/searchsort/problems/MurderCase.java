package com.app.searchsort.problems;

import java.util.Scanner;

public class MurderCase {
	private static int merge(int[] nums, int low, int mid, int high) {
		int n1 = (mid - low + 1);
		int n2 = (high - mid);
		int[] l1 = new int[n1];
		int[] l2 = new int[n2];

		int k = 0;
		for (int i = low; i <= mid; i++) {
			l1[k++] = nums[i];
		}

		k = 0;
		for (int i = mid + 1; i <= high; i++) {
			l2[k++] = nums[i];
		}

		int i = 0;
		int j = 0;
		k = low;

		int sum = 0;

		while (i < n1 && j < n2) {
			if (l1[i] < l2[j]) {
				sum += (l1[i] * (n2 - j));
				nums[k++] = l1[i++];
			} else {
				nums[k++] = l2[j++];
			}
		}

		while (i < n1) {
			nums[k++] = l1[i++];
		}

		while (j < n2) {
			nums[k++] = l2[j++];
		}

		return sum;
	}

	private static int mergeSort(int[] nums, int low, int high) {
		int sum = 0;
		if (low < high) {
			int mid = low + (high - low) / 2;
			int lSum = mergeSort(nums, low, mid);
			int rSum = mergeSort(nums, mid + 1, high);
			int mSum = merge(nums, low, mid, high);
			return (lSum + rSum + mSum);
		}
		return sum;
	}

	private static int findSum(int[] nums, int n) {
		return mergeSort(nums, 0, n - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();

		while (nTestCases > 0) {
			int nDim = scanner.nextInt();
			int[] nums = new int[nDim];
			for (int i = 0; i < nDim; i++) {
				nums[i] = scanner.nextInt();
			}

			int sum = findSum(nums, nDim);
			System.out.println(sum);
			nTestCases--;
		}
		scanner.close();

	}

}
