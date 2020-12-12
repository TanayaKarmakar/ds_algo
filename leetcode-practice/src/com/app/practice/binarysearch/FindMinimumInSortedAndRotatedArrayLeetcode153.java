package com.app.practice.binarysearch;

public class FindMinimumInSortedAndRotatedArrayLeetcode153 {
	private static int findMin(int[] nums) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		if(nums[start] <= nums[end])
			return nums[start];
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
				return nums[mid];
			else if (mid + 1 < n && nums[mid] > nums[mid + 1])
				return nums[mid + 1];
			else if (nums[start] <= nums[mid])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		
		int ans = findMin(nums);
		
		System.out.println(ans);

	}

}
