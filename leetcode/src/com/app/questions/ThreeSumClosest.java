package com.app.questions;

import java.util.Arrays;

public class ThreeSumClosest {
	private static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;

		int diff = Integer.MAX_VALUE;
		int res = 0;

		for (int i = 0; i < n; i++) {
			int start = i + 1;
			int end = n - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				int currentDiff = Math.abs(sum - target);
				
				if(currentDiff == 0)
					return sum;
				
				if (diff > currentDiff) {
					diff = currentDiff;
					res = sum;
				} 
				if(sum <= target) {
					start++;
				} else {
					end--;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };

		System.out.println(threeSumClosest(arr, 1));

		arr = new int[] { -1, 2, 1, -4 };

		System.out.println(threeSumClosest(arr, 1));

	}

}
