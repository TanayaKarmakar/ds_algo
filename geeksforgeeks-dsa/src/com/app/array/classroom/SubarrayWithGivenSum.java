package com.app.array.classroom;

public class SubarrayWithGivenSum {
	private static boolean isSubArrayExists1(int[] arr, int targetSum) {
		int n = arr.length;
		int sum = arr[0];
		int start = 0;
		for (int i = 1; i <= n; i++) {
			while (sum > targetSum && start < (i - 1)) {
				sum -= arr[start];
				start++;
			}

			if (sum == targetSum)
				return true;

			if (i < n) {
				sum += arr[i];
			}
		}

		return false;
	}

	private static boolean isSubArrayExists(int[] arr, int targetSum) {
		int n = arr.length;
		int start = 0;
		int sum = 0;
		int i = 0;

		while (i < n) {
			while (i < n && sum <= targetSum) {
				sum += arr[i];
				i++;
			}

			if (i == n - 1)
				return false;

			while (sum > targetSum) {
				sum -= arr[start];
				start++;
			}

			if (sum == targetSum)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 20, 3, 10, 5 };
		System.out.println(isSubArrayExists(arr, 15));
		System.out.println(isSubArrayExists1(arr, 15));
	}

}
