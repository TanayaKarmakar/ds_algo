package com.app.practice.binarysearch;

public class SearchInASortedAndRotatedArrayLeetcode81 {
	private static boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == target)
				return true;
			else if (nums[mid] > nums[end]) {
				if (target >= nums[start] && target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else if(nums[mid] < nums[end]) {
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			} else
				end--;
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
		int target = 0;
		
		System.out.println(search(nums, target));
		
		target = 3;
		
		System.out.println(search(nums, target));

	}

}
