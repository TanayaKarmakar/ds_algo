package com.app.searching.classroom;

public class SearchElementInASortedRotatedArrayWithDuplicates {
	private static int searchElement(int[] nums, int target, int low, int high) {
		if (high < low)
			return -1;
		int mid = low + (high - low) / 2;
		if (nums[mid] == target)
			return mid;

		if (nums[low] < nums[mid]) { // left half is sorted
			if (target >= nums[low] && target <= nums[mid])
				return searchElement(nums, target, low, mid - 1);
			else
				return searchElement(nums, target, mid + 1, high);

		} else if (nums[low] > nums[mid]) { // right half is sorted
			if (target >= nums[mid + 1] && target <= nums[high])
				return searchElement(nums, target, mid + 1, high);
			else
				return searchElement(nums, target, low, mid - 1);

		} else if (nums[low] == nums[mid]) { // left half is all duplicates
			if (nums[mid] != nums[high])
				return searchElement(nums, target, mid + 1, high);
			else {
				int result = searchElement(nums, target, low, mid - 1);
				if (result == -1)
					return searchElement(nums, target, mid + 1, high);
				else
					return result;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
		
		System.out.println(searchElement(nums, 0, 0, nums.length - 1));
		
		
		System.out.println(searchElement(nums, 3, 0, nums.length - 1));
	}

}
