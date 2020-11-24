package com.app.practice.greedy;

import java.util.Arrays;

public class ThreeSumClosestLeetcode16 {
	private static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int n = nums.length;

		int minDiff = Integer.MAX_VALUE;
		int closestSum = 0;

		for (int i = 0; i < n; i++) {
			int start = i + 1;
			int end = n - 1;

			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];

				if (sum == target) {
					return sum;
				} else {
					int currentDiff = Math.abs(target - sum);
					if (currentDiff < minDiff) {
						minDiff = currentDiff;
						closestSum = sum;
					}
					if (sum < target)
						start++;
					else
						end--;
				}
			}
		}
		return closestSum;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;
		
		int closestSum = threeSumClosest(nums, target);
		
		System.out.println(closestSum);

	}

}
