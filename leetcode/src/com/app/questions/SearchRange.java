package com.app.questions;

import java.util.Arrays;

//problem statement - Given an array of integers nums 
// sorted in ascending order, find the starting and ending position 
// of a given target value.
// Your algorithm's runtime complexity must be in the order of O(log n).
// If the target is not found in the array, return [-1, -1].
public class SearchRange {
	private static int[] searchRange(int[] nums, int target) {
		if(nums.length == 1) {
            if(nums[0] == target)
                return new int[]{0,0};
            else
                return new int[]{-1,-1};
        }
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				int leftMostIndx = -1;
				int rightMostIndx = -1;
				if (mid >= low) {
					if (mid == low || nums[mid - 1] != target)
						leftMostIndx = mid;
					else
						leftMostIndx = findLeftMostIndx(nums, low, mid - 1, target);
				}

				if (mid <= high) {
					if (mid == high || nums[mid + 1] != target)
						rightMostIndx = mid;
					else
						rightMostIndx = findRightMostIndx(nums, mid + 1, high, target);
				}
				return new int[] { leftMostIndx, rightMostIndx };
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return new int[] { -1, -1 };
	}

	private static int findLeftMostIndx(int[] nums, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == low || (mid > low && nums[mid - 1] != target))
					return mid;
				else if (nums[mid - 1] == target)
					high = mid - 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	private static int findRightMostIndx(int[] nums, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == high || (mid < high && nums[mid + 1] != target))
					return mid;
				else
					low = mid + 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };

		System.out.println(Arrays.toString(searchRange(nums, 8)));

		System.out.println(Arrays.toString(searchRange(nums, 6)));

		System.out.println(Arrays.toString(searchRange(nums, 7)));

		nums = new int[] { 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5 };
		
		System.out.println(Arrays.toString(searchRange(nums, 5)));
		
		nums = new int[] {1};
		
		System.out.println(Arrays.toString(searchRange(nums, 1)));
		
		System.out.println(Arrays.toString(searchRange(nums, 5)));
		
		nums= new int[] {2,2};
		
		System.out.println(Arrays.toString(searchRange(nums, 2)));
	}

}
