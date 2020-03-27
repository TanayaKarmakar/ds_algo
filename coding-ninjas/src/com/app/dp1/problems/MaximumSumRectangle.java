package com.app.dp1.problems;

import java.util.Arrays;

class KadaneResult {
	int maxSum;
	int start;
	int end;

	public KadaneResult(int maxSum, int start, int end) {
		this.maxSum = maxSum;
		this.start = start;
		this.end = end;
	}
}

public class MaximumSumRectangle {
	private static int maxSum = 0;
	private static int leftBound = 0;
	private static int rightBound = 0;
	private static int topBound = 0;
	private static int bottomBound = 0;

	private static int maxSumRectangle(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;

		int[] temp = new int[rows];

		for (int left = 0; left < cols; left++) {
			Arrays.fill(temp, 0);
			for (int right = left; right < cols; right++) {
				for (int i = 0; i < rows; i++) {
					temp[i] += mat[i][right];
				}
				KadaneResult res = kadane(temp);
				if (res.maxSum > maxSum) {
					leftBound = left;
					rightBound = right;
					topBound = res.start;
					bottomBound = res.end;
					maxSum = res.maxSum;
				}
			}
		}

		int sum = 0;
		for (int i = topBound; i <= bottomBound; i++) {
			for (int j = leftBound; j <= rightBound; j++) {
				sum += mat[i][j];
			}
		}

		return sum;
	}

	private static KadaneResult kadane(int[] arr) {
		int maxSoFar = Integer.MIN_VALUE;
		int maxStart = -1;
		int maxEnd = -1;

		int currentSum = 0;
		int currentStart = -1;
		// int currentEnd = -1;

		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];

			if (currentSum < 0) {
				currentSum = 0;
				currentStart = i + 1;
			}

			if (maxSoFar < currentSum) {
				maxStart = currentStart;
				maxEnd = i;
				maxSoFar = currentSum;
			}
		}

		return new KadaneResult(maxSoFar, maxStart, maxEnd);
	}

	public static void main(String[] args) {
		int[][] mat = { 
				{ 1, 2, -1, -4, -20 }, 
				{ -8, -3, 4, 2, 1 }, 
				{ 3, 8, 10, 1, 3 }, 
				{ -4, -1, 1, 7, -6 } 
		};
		
		int sum = maxSumRectangle(mat);
		
		System.out.println(sum);

	}

}
