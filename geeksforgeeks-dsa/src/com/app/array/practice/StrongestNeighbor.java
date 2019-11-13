package com.app.array.practice;

public class StrongestNeighbor {
	private static void strongestNeighbor(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < (n - 1); i++) {
			System.out.print(Integer.max(arr[i], arr[i + 1]) + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		strongestNeighbor(new int[] { 1, 2, 2, 3, 4, 5 });
	}

}
