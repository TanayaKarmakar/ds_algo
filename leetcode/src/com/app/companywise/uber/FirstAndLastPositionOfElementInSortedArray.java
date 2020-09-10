package com.app.companywise.uber;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {
	private static int findLeftMostIndx(int[] nums, int target) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
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
		int n = nums.length;

		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target && (mid == n - 1 || nums[mid + 1] != target))
				return mid;
			else if (nums[mid] <= target)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return -1;
	}

	private static int[] searchRange(int[] nums, int target) {
		int lIndx = findLeftMostIndx(nums, target);
		int rIndx = findRightMostIndx(nums, target);

		return new int[] { lIndx, rIndx };
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		
		int[] ans = searchRange(nums, target);
		
		System.out.println(Arrays.toString(ans));
	}

}
