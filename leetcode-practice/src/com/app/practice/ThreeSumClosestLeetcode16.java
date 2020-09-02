package com.app.practice;

import java.util.Arrays;

public class ThreeSumClosestLeetcode16 {
	private static int threeSumClosest(int[] nums, int target) {
		int n = nums.length;

		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;
		int closestSum = 0;
		int i = 0;

		while (i < n) {
			int num = nums[i];
			int start = i + 1;
			int end = n - 1;
			while (start < end) {
				int sum = num + nums[start] + nums[end];
				int diff = Math.abs(target - sum);
				if (diff == 0)
					return sum;
				if (minDiff > diff) {
					minDiff = diff;
					closestSum = sum;
				}
				if(sum >= target)
					end--;
				else
					start++;
			}
			i++;
		}
		return closestSum == Integer.MAX_VALUE ? 0 : closestSum;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;
		
		System.out.println(threeSumClosest(nums, target));
	}

}
