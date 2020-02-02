package com.app.heap.classroom;

public class BuyMaximumItemWithGivenSum {
	private static void swap(int[] nums, int indx1, int indx2) {
		int tmp = nums[indx1];
		nums[indx1] = nums[indx2];
		nums[indx2] = tmp;
	}

	private static void minHeapify(int[] nums, int i, int n) {
		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < n && nums[smallest] > nums[left]) {
			smallest = left;
		}
		if (right < n && nums[smallest] > nums[right]) {
			smallest = right;
		}
		if (smallest != i) {
			swap(nums, smallest, i);
			minHeapify(nums, smallest, n);
		}
	}

	private static void buildHeap(int[] nums, int n) {
		for (int i = (n - 1) / 2; i >= 0; i--) {
			minHeapify(nums, i, n);
		}
	}

	private static int buyItemsWithGivenSum(int[] nums, int sum) {
		int n = nums.length - 1;
		buildHeap(nums, n);

		int indx = 0;
		int currentSum = 0;
		for (int i = 0; i <= n; i++) {
			int el = nums[0];
			if (el < sum && currentSum < sum) {
				currentSum += el;
				swap(nums, 0, n - indx);
				++indx;
				minHeapify(nums, 0, n - indx);
			}
		}
		return indx;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 12, 111, 200 };

		System.out.println(buyItemsWithGivenSum(arr, 10));

	}

}
