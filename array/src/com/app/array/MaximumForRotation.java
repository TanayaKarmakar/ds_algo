package com.app.array;

public class MaximumForRotation {
	private static int findMaxSumForRotation(int[] arr) {
		int sum = 0;
		int maxRotationSum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			maxRotationSum += i * arr[i];
		}

		int prevRotation = maxRotationSum;
		for (int i = 1; i < n; i++) {
			int currentRotation = prevRotation + (n * arr[i - 1]) - sum;
			if (currentRotation > maxRotationSum) {
				maxRotationSum = currentRotation;
			}
			prevRotation = currentRotation;
		}

		return maxRotationSum;

	}

	public static void main(String[] args) {
		int[] arr = { 8, 3, 1, 2 };
		int sum = findMaxSumForRotation(arr);
		System.out.println("Maxrotation - " + sum);

	}

}
