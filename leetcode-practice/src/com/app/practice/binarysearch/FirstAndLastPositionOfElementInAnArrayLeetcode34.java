package com.app.practice.binarysearch;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInAnArrayLeetcode34 {
	private static int findLeftMostIndx(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target))
				return mid;
			else if (nums[mid] >= target)
				end = mid - 1;
			else
				start = mid + 1;
		}

		return -1;
	}

	private static int findRightMostIndx(int[] nums, int target) {
		int n = nums.length - 1;
		int start = 0;
		int end = n;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target && (mid == n || nums[mid + 1] != target))
				return mid;
			else if (nums[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}

		return -1;
	}

	private static int[] searchRange(int[] nums, int target) {
		int lIndx = findLeftMostIndx(nums, target);
		if (lIndx == -1)
			return new int[] { -1, -1 };
		int rIndx = findRightMostIndx(nums, target);
		return new int[] { lIndx, rIndx };
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 6;

		int[] ans = searchRange(nums, target);

		System.out.println(Arrays.toString(ans));
	}

}
