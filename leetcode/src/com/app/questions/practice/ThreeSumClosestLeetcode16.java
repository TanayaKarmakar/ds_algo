package com.app.questions.practice;

import java.util.Arrays;

public class ThreeSumClosestLeetcode16 {
	private static int threeSumClosest(int[] nums, int sum) {
		Arrays.sort(nums);
		int n = nums.length;

		int diff = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			int start = i + 1;
			int end = n - 1;
			while (start < end) {
				int currentSum = num + nums[start] + nums[end];
				if (currentSum == sum)
					return currentSum;

				int currentDiff = Math.abs(currentSum - sum);
				if (diff > currentDiff) {
					diff = currentDiff;
					res = currentSum;
				}

				if (currentSum <= sum) {
					start++;
				} else {
					end--;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { -1, 2, 1, -4 };
		
		int res = threeSumClosest(arr, 1);
		
		System.out.println(res);

	}

}
