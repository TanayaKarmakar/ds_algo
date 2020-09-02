package com.app.practice;

public class FindPeakElementLeetcode162 {
	private static boolean isPeak(int[] nums, int mid) {
		if (mid == 0) {
			if (mid + 1 < nums.length && nums[mid] > nums[mid + 1])
				return true;
			else
				return false;
		} else if (mid == nums.length - 1) {
			if (mid - 1 >= 0 && nums[mid - 1] < nums[mid])
				return true;
			else
				return false;
		} else {
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
				return true;
			else
				return false;
		}
	}

	private static int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isPeak(nums, mid))
				return mid;
			else if (mid > 0 && nums[mid] < nums[mid - 1])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };

		System.out.println(findPeakElement(nums));

		nums = new int[] { 1, 2, 1, 3, 5, 6, 4 };

		System.out.println(findPeakElement(nums));

	}

}
