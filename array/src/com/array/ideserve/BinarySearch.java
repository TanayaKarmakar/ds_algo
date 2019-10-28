package com.array.ideserve;

public class BinarySearch {
	private static int binarySearchRecursive(int[] arr, int key, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		if (arr[mid] == key)
			return mid;
		else if (arr[mid] < key)
			return binarySearchRecursive(arr, key, mid + 1, end);
		else
			return binarySearchRecursive(arr, key, start, mid - 1);
	}

	private static int binarySearchIterative(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 12, 14, 20, 22, 24, 27, 28, 30, 35, 37, 39, 45, 48, 49 };

		int key = 28;

		System.out.println("Index of " + key + " is " + binarySearchIterative(arr, key));

		key = 34;
		System.out.println("Index of " + key + " is " + binarySearchIterative(arr, key));

		key = 28;

		System.out.println("Index of " + key + " is " + binarySearchRecursive(arr, key, 0, arr.length - 1));

		key = 34;
		System.out.println("Index of " + key + " is " + binarySearchRecursive(arr, key, 0, arr.length - 1));

		arr = new int[] { -2, -2, -2, -2, -2, -2, -2, -2 };
		key = 23;
		
		System.out.println("Index of " + key + " is " + binarySearchRecursive(arr, key, 0, arr.length - 1));
	
		key = -2;
		System.out.println("Index of " + key + " is " + binarySearchRecursive(arr, key, 0, arr.length - 1));
	}

}
