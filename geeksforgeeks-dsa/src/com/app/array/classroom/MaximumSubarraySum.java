package com.app.array.classroom;

public class MaximumSubarraySum {
	private static int maxSumSubarray(int[] arr, int windowSize) {
		int maxSum = 0;
		int sum = 0;
		int n = arr.length;
		int count = 0;
		while (count < windowSize) {
			sum += arr[count];
			count++;
		}

		for (int i = 0; i < n; i++) {
			if(maxSum < sum) {
				maxSum = sum;
			}
			sum -= arr[i];
			if((i + windowSize) < n) {
				sum += arr[i + windowSize];
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 8, 30, -5, 20, 7 };
		System.out.println("Max subarray sum - " + maxSumSubarray(arr, 3));
	}

}
