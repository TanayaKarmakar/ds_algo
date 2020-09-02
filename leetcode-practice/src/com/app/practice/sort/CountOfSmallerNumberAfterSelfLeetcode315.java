package com.app.practice.sort;

import java.util.ArrayList;
import java.util.List;

class Item {
	int val;
	int indx;

	public Item(int val, int indx) {
		this.val = val;
		this.indx = indx;
	}
}

public class CountOfSmallerNumberAfterSelfLeetcode315 {
	private static void merge(Item[] items, int low, int mid, int high, int[] count) {
		int n1 = (mid - low + 1);
		int n2 = (high - mid);

		Item[] left = new Item[n1];
		Item[] right = new Item[n2];

		int i = 0;
		for (int j = low; j <= mid; j++) {
			left[i++] = items[j];
		}

		i = 0;
		for (int j = mid + 1; j <= high; j++) {
			right[i++] = items[j];
		}

		int k = low;
		i = 0;
		int j = 0;
		int rightCounter = 0;
		while (i < n1 && j < n2) {
			if (left[i].val > right[j].val) {
				rightCounter++;
				items[k++] = right[j++];
			} else {
				count[left[i].indx] += rightCounter;
				items[k++] = left[i++];
			}
		}

		while (i < n1) {
			count[left[i].indx] += rightCounter;
			items[k++] = left[i++];
		}

		while (j < n2) {
			items[k++] = right[j++];
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
		List<Integer> res = countSmaller(nums);
		
		System.out.println(res);
	}

}
