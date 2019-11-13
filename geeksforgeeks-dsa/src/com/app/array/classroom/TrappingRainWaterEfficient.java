package com.app.array.classroom;

public class TrappingRainWaterEfficient {
	private static int trapWater(int[] arr) {
		int low = 0;
		int high = arr.length - 1;

		int lMax = 0;
		int hMax = 0;

		int water = 0;

		while (low <= high) {
			if (arr[low] < arr[high]) {
				if (arr[low] > lMax) {
					lMax = arr[low];
				} else {
					water += (lMax - arr[low]);
				}
				low++;
			} else {
				if (arr[high] > hMax) {
					hMax = arr[high];
				} else {
					water += (hMax - arr[high]);
				}
				high--;
			}
		}

		return water;
	}

	public static void main(String[] args) {
		// TestCase1
		int[] arr = { 3, 0, 1, 2, 5 };
		System.out.println("Trapped rain water - " + trapWater(arr) + " units");

		// TestCase2
		arr = new int[] { 4, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Trapped rain water - " + trapWater(arr) + " units");
	}

}
