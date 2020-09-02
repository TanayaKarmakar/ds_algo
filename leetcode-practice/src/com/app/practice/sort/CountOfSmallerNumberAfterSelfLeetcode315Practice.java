package com.app.practice.sort;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumberAfterSelfLeetcode315Practice {
	private static void merge(Item[] items, int low, int mid, int high, int[] count) {
		int n1 = (mid - low + 1);
		int n2 = (high - mid);
		Item[] l = new Item[n1];
		Item[] r = new Item[n2];

		int k = 0;
		for (int i = low; i <= mid; i++) {
			l[k++] = items[i];
		}

		k = 0;
		for (int i = mid + 1; i <= high; i++) {
			r[k++] = items[i];
		}

		k = low;
		int i = 0;
		int j = 0;
		int rightCounter = 0;

		while (i < n1 && j < n2) {
			if (l[i].val > r[j].val) {
				items[k++] = r[j++];
				rightCounter++;
			} else {
				count[l[i].indx] += rightCounter;
				items[k++] = l[i++];
			}
		}

		while (i < n1) {
			count[l[i].indx] += rightCounter;
			items[k++] = l[i++];
		}

		while (j < n2) {
			items[k++] = r[j++];
		}
	}

	private static void mergeSort(Item[] items, int low, int high, int[] count) {
		if (low >= high)
			return;
		int mid = low + (high - low) / 2;
		mergeSort(items, low, mid, count);
		mergeSort(items, mid + 1, high, count);
		merge(items, low, mid, high, count);
	}

	private static List<Integer> countSmaller(int[] nums) {
		int n = nums.length;

		Item[] items = new Item[n];
		for (int i = 0; i < n; i++) {
			items[i] = new Item(nums[i], i);
		}

		int[] count = new int[n];

		mergeSort(items, 0, n - 1, count);

		List<Integer> res = new ArrayList<>();
		for (int cnt : count) {
			res.add(cnt);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 2, 6, 1 };
		
		List<Integer> output = countSmaller(nums);
		
		System.out.println(output);

	}

}
