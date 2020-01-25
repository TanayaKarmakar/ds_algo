package com.app.questions;

public class PeakElement {
	private static boolean isPeak(int[] nums, int indx) {
		if (indx == 0)
			return nums[indx] > nums[indx + 1];
		else if (indx == nums.length - 1)
			return nums[indx] > nums[indx - 1];
		else
			return (nums[indx] > nums[indx - 1]) && (nums[indx] > nums[indx + 1]);

	}

	private static int findPeak(int[] nums) {
		if(nums.length == 1)
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
		int[] nums = { 1, 2, 1, 3, 5, 6, 4 };

		System.out.println(findPeak(nums));

		nums = new int[] { 1, 2, 3, 1 };

		System.out.println(findPeak(nums));

		nums = new int[] {1,2};
		
		System.out.println(findPeak(nums));
		
		nums = new int[] {1};
		
		System.out.println(findPeak(nums));
	}

}
