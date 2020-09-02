package com.app.practice;

public class SearchInsertPositionLeetcode35 {
	private static int searchInsertPosition(int[] nums, int target) {
		int n = nums.length;
		int low = 0;
		int high = n - 1;

		int pos = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target) {
				pos = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return pos == -1 ? n: pos;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		
		System.out.println(searchInsertPosition(nums, 5));
		
		System.out.println(searchInsertPosition(nums, 2));
		
		System.out.println(searchInsertPosition(nums, 7));
		
		System.out.println(searchInsertPosition(nums, 0));

	}

}
