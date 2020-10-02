package com.app.practice.binarysearch;

public class SearchInASortedRotatedArrayIILeetcode81 {
	private static boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[mid] < nums[end]) {
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid;
			} else if (nums[mid] > nums[end]) {
				if (target >= nums[start] && target < nums[mid])
					end = mid;
				else
					start = mid + 1;
			} else {
				end--;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
		int target = 0;
		
		boolean ans = search(nums, target);
		System.out.println(ans);
	}

}
