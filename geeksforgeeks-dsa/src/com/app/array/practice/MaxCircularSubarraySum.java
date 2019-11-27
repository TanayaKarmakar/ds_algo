package com.app.array.practice;

import java.util.Arrays;

public class MaxCircularSubarraySum {
	private static int kadane(int[] arr) {
		int n = arr.length;
		int localSum = 0;
		int globalSum = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			localSum = Integer.max(arr[i], localSum + arr[i]);

			if (localSum > globalSum) {
				globalSum = localSum;
			}
		}

		return globalSum;
	}

	private static int maxCircularSubarraySum(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		if(max < 0)
			return max;
		
		int maxNonCircularSum = kadane(arr);

		int n = arr.length;
		int arrSum = 0;

		for (int i = 0; i < n; i++) {
			arrSum += arr[i];
			arr[i] = -arr[i];
		}

		int maxInvSum = kadane(arr);
		return Integer.max(maxNonCircularSum, arrSum + maxInvSum);
	}

	public static void main(String[] args) {
		int[] arr = { 8, -8, 9, -9, 10, -11, 12 };

		System.out.println(maxCircularSubarraySum(arr));

	}

}
