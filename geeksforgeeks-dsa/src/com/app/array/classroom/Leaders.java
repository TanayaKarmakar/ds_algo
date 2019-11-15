package com.app.array.classroom;

public class Leaders {
	private static void leaders(int[] arr) {
		int n = arr.length;
		int i = n - 2;
		int max = arr[n - 1];
		StringBuilder sb = new StringBuilder();
		sb.append(max + " ");
		while (i >= 0) {
			if (arr[i] >= max) {
				max = arr[i];
				sb.append(max + " ");
			}
			i--;
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		int[] arr = { 10, 15, 8, 25, 3, 7 };
		leaders(arr);

		arr = new int[] { 5, 3, 20, 15, 8, 3 };
		leaders(arr);

	}

}
