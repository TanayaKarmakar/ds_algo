package com.app.questions;

public class SearchInsertPosition {
	private static int findInsertPosition(int[] nums, int target) {
		if(nums[0] > target)
			return 0;
		int indx = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] == target)
				return i;
			else if (nums[i] < target)
				indx++;
		}
		return indx;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(findInsertPosition(nums, 5));
		
		System.out.println(findInsertPosition(nums, 2));
		
		System.out.println(findInsertPosition(nums, 7));
		
		System.out.println(findInsertPosition(nums, 0));
	}

}
