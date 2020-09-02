package com.app.practice;

public class FindMinimumInSortedRotatedArrayLeetcode153 {
	private static int findMinimum(int[] nums) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (mid + 1 < n && nums[mid] > nums[mid + 1])
				return nums[mid + 1];
			else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
				return nums[mid];
			else if (nums[start] < nums[mid])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return nums[0];
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 1, 2 };

		System.out.println(findMinimum(nums));

		nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		
		System.out.println(findMinimum(nums));
	}

}
