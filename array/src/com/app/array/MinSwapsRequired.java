package com.app.array;

public class MinSwapsRequired {
	private static int minSwapsRequired(int[] arr, int k) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] <= k) {
				count++;
			}
		}

		int bad = 0;
		for (int i = 0; i < count; i++) {
			if (arr[i] > k) {
				bad++;
			}
		}

		int ans = bad;
		for (int i = 0, j = count; j < n; i++, j++) {
			System.out.println("i : " + i + " | j : " + j);
			if (arr[i] > k)
				bad--;
			if (arr[j] > k)
				bad++;

			ans = Integer.min(ans, bad);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 9, 5, 8, 7, 4 };
		int numSwaps = minSwapsRequired(arr, 5);
		System.out.println("Number of swaps - " + numSwaps);

		System.out.println("TestCase2");
		arr = new int[] { 2, 1, 5, 6, 3 };
		numSwaps = minSwapsRequired(arr, 3);
		System.out.println("Number of swaps - " + numSwaps);
	}

}
