package com.app.array.classroom;

public class PrefixSumTechnique1 {
	private static int findSum(int[] arr, int l, int r) {
		int prefixSum[] = new int[arr.length];

		prefixSum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		if (l != 0) {
			return prefixSum[r] - prefixSum[l - 1];
		} else {
			return prefixSum[r];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 8, 3, 9, 6, 5, 4 };

		System.out.println("Prefix Sum " + findSum(arr, 0, 2));
		System.out.println("Prefix Sum " + findSum(arr, 1, 3));
	}

}
