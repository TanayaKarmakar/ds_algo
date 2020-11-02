package com.app.practice.binarysearch;

public class SearchInsertPositionLeetcode35 {
	private static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		int ans = -1;
		while(start <= end) {
			int mid = (start + end) >> 1;
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] > target) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return ans == -1 ? n : ans;
	}

	public static void main(String[] args) {
		

	}

}
