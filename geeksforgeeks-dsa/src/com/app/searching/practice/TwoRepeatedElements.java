package com.app.searching.practice;

public class TwoRepeatedElements {
	private static void twoRepeatedElements(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			int k = Math.abs(arr[i]);
			if (arr[k] > 0) {
				arr[k] = -arr[k];
			} else {
				System.out.print(k + " ");
			}
		}

		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 1, 3, 4, 3 };
		twoRepeatedElements(arr);

		arr = new int[] { 1, 2, 2, 1 };
		twoRepeatedElements(arr);

		arr = new int[] { 1, 1, 2, 2 };
		twoRepeatedElements(arr);
	}

}
