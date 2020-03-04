package com.app.dynamicprogramming.classroom;

public class MaxSumRecurisve {
	private static int maxSum(int[] arr, int n) {
		if (n == 1)
			return arr[0];
		else if (n == 2)
			return Integer.max(arr[0], arr[1]);
		else
			return Integer.max(maxSum(arr, n - 1), maxSum(arr, n - 2) + arr[n - 1]);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 5, 15, 20 };
		
		System.out.println("Maximum sum - " + maxSum(arr, arr.length));

	}

}
