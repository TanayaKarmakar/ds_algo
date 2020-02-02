package com.app.questions;

public class SearchInSortedRotatedArray {
	private static int findPivot(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid - 1) >= 0 && nums[mid - 1] > nums[mid])
				return mid - 1;
			else if ((mid + 1) < nums.length && nums[mid] > nums[mid + 1])
				return mid;
			else {
				if (nums[low] <= nums[mid])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		return -1;
	}

	private static int binarySearch(int[] nums, int target, int low, int high) {
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

	private static int search(int[] nums, int target) {
		int pivotIndx = findPivot(nums);
		if (pivotIndx == -1)
			// do a complete binary search, coz array is not rotated at all
			return binarySearch(nums, target, 0, nums.length);
		else if (target >= nums[0] && target <= nums[pivotIndx])
			return binarySearch(nums, target, 0, pivotIndx);
		else
			return binarySearch(nums, target, pivotIndx + 1, nums.length - 1);
	}

	public static void main(String[] args) {
		/*int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

		int x = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			x = nums[i];

			System.out.println("Index of " + x + " is " + search(nums, x));
		}

		x = 9;

		System.out.println("Index of " + x + " is " + search(nums, x));

		x = 3;

		System.out.println("Index of " + x + " is " + search(nums, x));

		nums = new int[] { 1, 3 };

		x = 0;

		System.out.println("Index of " + x + " is " + search(nums, x));*/

		int[] nums = new int[] { 3, 4, 5, 6, 1, 2 };

		int x = 2;

		System.out.println("Index of " + x + " is " + search(nums, x));
	}

}
