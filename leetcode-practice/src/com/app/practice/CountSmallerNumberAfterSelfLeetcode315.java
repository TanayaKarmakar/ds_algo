package com.app.practice;

import java.util.ArrayList;
import java.util.List;

class Item1 {
	int value;
	int indx;

	public Item1(int value, int indx) {
		this.value = value;
		this.indx = indx;
	}
}

public class CountSmallerNumberAfterSelfLeetcode315 {
	private static List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		Item1[] items = new Item1[n];

		for (int i = 0; i < n; i++) {
			items[i] = new Item1(nums[i], i);
		}

		int[] count = new int[n];
		mergeSort(items, 0, n - 1, count);

		List<Integer> res = new ArrayList<>();
		for (int val : count) {
			res.add(val);
		}

		return res;
	}

	private static void mergeSort(Item1[] items, int low, int high, int[] count) {
		if (low >= high)
			return;
		int mid = low + (high - low) / 2;
		mergeSort(items, low, mid, count);
		mergeSort(items, mid + 1, high, count);
		merge(items, low, mid, high, count);
	}

	private static void merge(Item1[] items, int low, int mid, int high, int[] count) {
		int n1 = (mid - low + 1);
		int n2 = (high - mid);

		Item1[] left = new Item1[n1];
		Item1[] right = new Item1[n2];

		int i = 0;
		int j = 0;
		int k = 0;

		for (i = low; i <= mid; i++) {
			left[k++] = items[i];
		}

		k = 0;
		for (i = mid + 1; i <= high; i++) {
			right[k++] = items[i];
		}

		int rightCount = 0;
		k = low;
		i = 0;
		j = 0;
		while (i < n1 && j < n2) {
			if (left[i].value <= right[j].value) {
				count[left[i].indx] += rightCount;
				items[k++] = left[i++];
			} else {
				items[k++] = right[j++];
				rightCount++;
			}
		}

		while (i < n1) {
			count[left[i].indx] += rightCount;
			items[k++] = left[i++];
		}

		while (j < n2) {
			items[k++] = right[j++];
		}

	}

	public static void main(String[] args) {
		int[] nums = { 5, 2, 6, 1 };

		List<Integer> res = countSmaller(nums);
		
		System.out.println(res);
	}

}
