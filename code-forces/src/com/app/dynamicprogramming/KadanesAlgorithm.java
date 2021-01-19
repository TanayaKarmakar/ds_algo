package com.app.dynamicprogramming;

public class KadanesAlgorithm {
	private static int maxSum(int[] nums) {
		int n = nums.length;
		
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			currentSum += nums[i];
			
			if(currentSum < 0)
				currentSum = 0;
			maxSum = Integer.max(maxSum, currentSum);
		}
		
		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = {};

	}

}
