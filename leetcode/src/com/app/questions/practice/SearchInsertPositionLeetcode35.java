package com.app.questions.practice;

public class SearchInsertPositionLeetcode35 {
	private static int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int indx = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				indx = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (indx == -1) {
			if (target > nums[end])
				indx = end + 1;
		}
		return indx;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		int indx = searchInsert(nums, 2);

		System.out.println("Index - " + indx);

		nums = new int[] { 1, 3, 5, 6 };

		indx = searchInsert(nums, 5);

		System.out.println("Index - " + indx);

		nums = new int[] { 1, 3, 5, 6 };

		indx = searchInsert(nums, 0);
		
		System.out.println("Index - " + indx);
		
		

	}

}
