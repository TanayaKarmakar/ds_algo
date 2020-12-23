package com.app.search;

public class SearchLeftMostIndexInASortedArray {
	private static int findLeftMostIndx(int[] nums, int el) {
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == el && (mid == 0 || nums[mid - 1] != el))
				return mid;
			else if (nums[mid] >=  el)
				end = mid - 1;
			else
				start = mid + 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 };
		int el = 108;

		int indx = findLeftMostIndx(nums, el);

		System.out.println("Index - " + indx);

	}

}
