package com.app.questions.practice;

public class SearchInASortedRotatedArrayLeetcode33 {
	private static int findPivot(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid + 1 < nums.length && nums[mid] > nums[mid + 1])
				return mid;
			else if (mid - 1 >= 0 && nums[mid] < nums[mid - 1])
				return mid - 1;
			else if (nums[low] < nums[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}

		return -1;
	}

	private static int binarySearch(int[] nums, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return -1;
	}

	private static int findElement(int[] nums, int target) {
		int pivotIndx = findPivot(nums);
		if (pivotIndx == -1)
			return binarySearch(nums, 0, nums.length - 1, target);
		else if (target >= nums[0] && target <= nums[pivotIndx])
			return binarySearch(nums, 0, pivotIndx, target);
		else
			return binarySearch(nums, pivotIndx + 1, nums.length - 1, target);
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println(findElement(nums, 0));

		nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println(findElement(nums, 3));
	}

}
