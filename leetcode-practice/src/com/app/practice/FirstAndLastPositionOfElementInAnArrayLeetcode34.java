package com.app.practice;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInAnArrayLeetcode34 {
	private static int findLeftMostIndx(int[] nums, int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target))
				return mid;
			else if (nums[mid] >= target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	private static int findRightMostIndx(int[] nums, int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target))
				return mid;
			else if (nums[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	private static int[] searchRange(int[] nums, int target) {
		int lIndx = findLeftMostIndx(nums, target, 0, nums.length - 1);
		int rIndx = findRightMostIndx(nums, target, 0, nums.length - 1);
		return new int[] { lIndx, rIndx };
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		System.out.println(Arrays.toString(searchRange(nums, 8)));

		nums = new int[] { 5, 7, 7, 8, 8, 10 };
		System.out.println(Arrays.toString(searchRange(nums, 6)));
	}

}
