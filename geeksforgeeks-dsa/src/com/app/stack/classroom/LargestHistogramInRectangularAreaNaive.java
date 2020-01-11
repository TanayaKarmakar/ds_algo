package com.app.stack.classroom;

public class LargestHistogramInRectangularAreaNaive {
	private static int largestRectangle(int[] arr) {
		int n = arr.length;
		int res = 0;

		for (int i = 0; i < n; i++) {
			int curr = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] >= arr[i]) {
					curr += arr[i];
				} else
					break;
			}

			for (int j = i + 1; j < n; j++) {
				if (arr[j] >= arr[i]) {
					curr += arr[i];
				} else
					break;
			}

			res = Integer.max(res, curr);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 6, 2, 5, 4, 1, 5, 6 };
		System.out.println("Largest Histogram in Rectangle - " + largestRectangle(arr));
	}

}
