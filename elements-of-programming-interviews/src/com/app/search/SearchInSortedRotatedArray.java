package com.app.search;

public class SearchInSortedRotatedArray {
	private static int searchSmallest(int[] nums) {
		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return start;
	}

	public static void main(String[] args) {
		int[] nums = { 378, 478, 550, 631, 103, 203, 220, 234, 279, 368 };
		
		int indx = searchSmallest(nums);
		
		System.out.println(indx);
	}

}
