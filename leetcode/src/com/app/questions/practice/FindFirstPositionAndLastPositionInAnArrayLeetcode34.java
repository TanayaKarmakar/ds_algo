package com.app.questions.practice;

public class FindFirstPositionAndLastPositionInAnArrayLeetcode34 {
	private static int findLeftMostIndx(int[] nums, int target, int low, int high) {
		while(low <= high) {
			int mid = low + (high - low)/2;
			if(nums[mid] == target && (mid == 0 || nums[mid - 1]!= target))
				return mid;
			else if(nums[mid] >= target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}
	
	private static int findRightMostIndx(int[] nums, int target, int low, int high) {
		while(low <= high) {
			int mid = low + (high - low)/2;
			if(nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target))
				return mid;
			else if(nums[mid] <= target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
	
	private static int[] findFirstLast(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				int lIndx = findLeftMostIndx(nums, target, low, high);
				int rIndx = findRightMostIndx(nums, target, low, high);
				return new int[] { lIndx, rIndx };
			} else if (nums[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {

	}

}
