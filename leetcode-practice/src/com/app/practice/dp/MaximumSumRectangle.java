package com.app.practice.dp;

import java.util.Arrays;

class KadaneResult {
	int maxSum;
	int maxStart;
	int maxEnd;

	public KadaneResult(int maxSum, int maxStart, int maxEnd) {
		this.maxSum = maxSum;
		this.maxStart = maxStart;
		this.maxEnd = maxEnd;
	}
}

public class MaximumSumRectangle {
	private static int maxSum = 0;
	private static int maxSumLeft = 0;
	private static int maxSumRight = 0;
	private static int maxSumTop = 0;
	private static int maxSumBottom = 0;

	private static int maximumSumRectangle(int[][] nums) {
		int rows = nums.length;
		int cols = nums[0].length;

		int[] temp = new int[rows];
		maxSum = 0;

		for (int left = 0; left < cols; left++) {
			Arrays.fill(temp, 0);
			for (int right = left; right < cols; right++) {
				for (int i = 0; i < rows; i++) {
					temp[i] += nums[i][right];
				}
				KadaneResult result = kadane(temp, rows);
				if (result.maxSum > maxSum) {
					maxSum = result.maxSum;
					maxSumLeft = left;
					maxSumRight = right;
					maxSumTop = result.maxStart;
					maxSumBottom = result.maxEnd;
				}
			}
		}

		int sum = 0;
		for (int i = maxSumTop; i <= maxSumBottom; i++) {
			for (int j = maxSumLeft; j <= maxSumRight; j++) {
				sum += nums[i][j];
			}
		}

		return sum;
	}

	private static KadaneResult kadane(int[] temp, int rows) {
		int maxStart = -1;
		int maxEnd = -1;
		int maxSum = Integer.MIN_VALUE;

		int currentSum = 0;
		int currentStart = -1;

		for (int i = 0; i < rows; i++) {
			currentSum += temp[i];
			if (currentSum < 0) {
				currentSum = 0;
				currentStart = i + 1;
			}
			if (currentSum > maxSum) {
				maxSum = currentSum;
				maxStart = currentStart;
				maxEnd = i;
			}
		}
		return new KadaneResult(maxSum, maxStart, maxEnd);
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 2, -1, -4, 20 }, { 8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };
	
		int maxSum = maximumSumRectangle(nums);
		
		System.out.println(maxSum);
	}

}
