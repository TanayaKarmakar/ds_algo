package com.app.array.dc;

public class MaximumContiguousSubarrayDC {
	private static int sumCrossingBoundary(int[] arr, int low, int mid, int high) {
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid; i >= low; i--) {
			sum += arr[i];
			if (sum > leftSum) {
				leftSum = sum;
			}
		}

		sum = 0;
		int rightSum = Integer.MIN_VALUE;
		for (int i = high; i >= (mid + 1); i--) {
			sum += arr[i];
			if (sum > rightSum) {
				rightSum = sum;
			}
		}

		return (leftSum + rightSum);
	}

	private static int maxSubarray(int[] arr, int low, int high) {
		if (low == high) {
			return arr[low];
		}

		int mid = (low + high) / 2;
		int leftSum = maxSubarray(arr, low, mid);
		int rightSum = maxSubarray(arr, mid + 1, high);
		int crossingSum = sumCrossingBoundary(arr, low, mid, high);

		return Integer.max(leftSum, Integer.max(rightSum, crossingSum));

	}

	public static void main(String[] args) {
		int[] arr = { 3, -1, -1, 10, -3, -2, 4 };
		
		int sum = maxSubarray(arr, 0, arr.length - 1);
		System.out.println("Sum - " + sum);

	}

}
