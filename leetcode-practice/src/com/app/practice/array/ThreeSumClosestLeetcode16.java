package com.app.practice.array;

import java.util.Arrays;

public class ThreeSumClosestLeetcode16 {
	private static int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		Arrays.sort(nums);

		int minDiff = Integer.MAX_VALUE;
		int closestSum = 0;
		for (int i = 0; i < n; i++) {
			int start = i + 1;
			int end = n - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				int diff = Math.abs(sum - target);
				if (diff == 0)
					return sum;
				if (minDiff > diff) {
					minDiff = diff;
					closestSum = sum;
				}
					
				if (sum >= target)
					end--;
				else
					start++;
			}
		}

		return closestSum;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, 4 };
		int ans = threeSumClosest(nums, 1);
		
		System.out.println(ans);

	}

}
