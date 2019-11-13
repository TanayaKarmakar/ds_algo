package com.app.array.classroom;

public class TrappingRainWater {
	private static int waterTrapped(int[] arr) {
		int n = arr.length;
		int[] left = new int[n];
		int[] right = new int[n];

		left[0] = arr[0];
		for (int i = 1; i < n; i++) {
			left[i] = Integer.max(left[i - 1], arr[i]);
		}

		right[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Integer.max(arr[i], right[i + 1]);
		}

		int water = 0;
		for (int i = 0; i < n; i++) {
			water += Integer.min(left[i], right[i]) - arr[i];
		}
		return water;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 0, 1, 2, 5 };
		System.out.println("Rain water trapped - " + waterTrapped(arr) + " units");
	}
}
