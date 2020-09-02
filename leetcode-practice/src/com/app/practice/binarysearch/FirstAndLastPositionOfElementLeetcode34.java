package com.app.practice.binarysearch;

import java.util.Arrays;

public class FirstAndLastPositionOfElementLeetcode34 {
	private static int findLeftMostIndx(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;

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

	private static int findRightMostIndx(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int n = nums.length;

		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == target && (mid == n - 1 || nums[mid + 1] != target))
				return mid;
			else if (nums[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}

		return -1;
	}

	private static int[] findPositions(int[] nums, int target) {
		if (nums.length == 0)
			return new int[] { -1, -1 };
		if (nums.length == 1) {
			if (nums[0] == target)
				return new int[] { 0, 0 };
			else
				return new int[] { -1, -1 };

		}

		int leftMostIndx = findLeftMostIndx(nums, target);
		if (leftMostIndx == -1)
			return new int[] { -1, -1 };
		int rightMostIndx = findRightMostIndx(nums, target);

		return new int[] { leftMostIndx, rightMostIndx };
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;

		System.out.println(Arrays.toString(findPositions(nums, target)));
	}

}
