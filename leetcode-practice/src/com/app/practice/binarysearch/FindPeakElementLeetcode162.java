package com.app.practice.binarysearch;

public class FindPeakElementLeetcode162 {
	private static boolean isPeak(int[] nums, int mid, int n) {
		if (mid == 0)
			return (nums[mid] > nums[mid + 1]);
		else if (mid == n - 1)
			return (nums[mid] > nums[mid - 1]);
		else
			return (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]);
	}

	private static int findPeakElement(int[] nums) {
		if (nums.length == 0)
			return -1;
		if (nums.length == 1)
			return 0;
		int n = nums.length;
		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isPeak(nums, mid, n))
				return mid;
			else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		int indx = findPeakElement(nums);
		
		System.out.println(indx);
	}

}
