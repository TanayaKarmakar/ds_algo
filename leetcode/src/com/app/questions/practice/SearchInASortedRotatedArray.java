package com.app.questions.practice;

public class SearchInASortedRotatedArray {
	private static int findPivot(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid + 1 < nums.length && nums[mid] > nums[mid + 1])
				return mid;
			else if (mid > 0 && nums[mid - 1] > nums[mid])
				return mid - 1;
			else if (nums[start] <= nums[mid])
				start = mid + 1;
			else
				end = mid - 1;

		}
		return -1;
	}

	private static int binarySearch(int[] nums, int target, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	private static int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		if (nums.length == 1) {
			if (nums[0] == target)
				return 0;
			else
				return -1;
		}

		int pivotIndx = findPivot(nums);
		if (pivotIndx == -1)
			return binarySearch(nums, target, 0, nums.length - 1);
		else if (target >= nums[0] && target <= nums[pivotIndx]) {
			return binarySearch(nums, target, 0, pivotIndx);
		} else
			return binarySearch(nums, target, pivotIndx + 1, nums.length - 1);
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		
		int indx = search(nums, target);
		
		System.out.println(indx);

	}

}
