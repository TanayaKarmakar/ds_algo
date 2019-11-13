package com.app.array.classroom;

public class Leaders {
	private static void leaders(int[] arr) {
		int n = arr.length - 1;
		int max = arr[n];
		int prev = arr[n];
		boolean printed = false;
		for (int i = n; i >= 0; i--) {
			if ((prev != max || i == n) && !printed) {
				System.out.print(max + "\t");
				printed = true;
			}
			if ((i - 1) > 0 && arr[i - 1] > max) {
				prev = max;
				max = arr[i - 1];
				printed = false;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 10, 15, 8, 25, 3, 7 };
		leaders(arr);

		arr = new int[] { 5, 3, 20, 15, 8, 3 };
		leaders(arr);
	}

}
