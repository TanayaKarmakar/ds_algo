package com.app.questions;

import java.util.Arrays;

public class MaximumSumHackerRank {
	private static int getMaxSubarraySum(int[] nums, int n) {
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			currentSum += nums[i];
			if(currentSum < 0) {
				currentSum = 0;
			}
			maxSum = Integer.max(currentSum, maxSum);
		}
		return maxSum;
	}
	
	private static int getMaxSubseqSum(int[] nums, int n) {
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			if(nums[i] > 0) {
				currentSum += nums[i];
			}
		}
		if(currentSum == 0) {
			Arrays.sort(nums);
			currentSum += nums[n - 1];
		}
		return currentSum;
	}
	
	private static int[] getMaxSums(int[] nums) {
		int n = nums.length;
		return new int[] {getMaxSubarraySum(nums, n), getMaxSubseqSum(nums, n)};
	}

	public static void main(String[] args) {
		int[] nums = {2, -1, 2, 3, 4, -5};
		
		System.out.println(Arrays.toString(getMaxSums(nums)));

	}

}
