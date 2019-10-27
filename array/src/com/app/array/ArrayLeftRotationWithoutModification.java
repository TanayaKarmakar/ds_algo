package com.app.array;

public class ArrayLeftRotationWithoutModification {
	private static void leftRotation(int[] arr, int k) {
		int n = arr.length;
		for (int i = k; i < (k + n); i++) {
			System.out.print(arr[i % n] + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9};
		
		leftRotation(arr, 1);
		leftRotation(arr, 2);
		leftRotation(arr, 3);
		leftRotation(arr, 4);
		leftRotation(arr, 5);
		leftRotation(arr, 6);
	}

}
