package com.app.dynamicprogramming.classroom;

public class MaxSumSpaceOptimized {
	private static int getMaxSum(int[] arr, int n) {
		if (n == 1)
			return arr[0];
		int prevPrev = arr[0];
		int prev = Integer.max(arr[0], arr[1]);
		int res = prev;

		for (int i = 3; i <= n; i++) {
			res = Integer.max(prev, prevPrev + arr[i - 1]);
			prevPrev = prev;
			prev = res;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 5, 15, 20 };
		
		System.out.println("Maximum Sum - " + getMaxSum(arr, arr.length));

	}

}
