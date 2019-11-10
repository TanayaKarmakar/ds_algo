package com.array.ideserve;

public class BinarySearchRotatedArray {
	private static int findPivot(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] > arr[mid + 1])
				return (mid + 1);
			else {
				if (arr[start] <= arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	private static int searchElement(int[] arr, int searchKey) {
		int pivotIndx = findPivot(arr);
		if (arr[0] > searchKey) {
			return findElement(arr, pivotIndx, arr.length - 1, searchKey);
		} else {
			return findElement(arr, 0, pivotIndx - 1, searchKey);
		}

	}

	private static int findElement(int[] arr, int start, int end, int key) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 73, 85, 94, 21, 27, 34, 47, 54, 66 };
		
		int searchKey = 34;
		System.out.println("Element " + searchKey + " is present at " + searchElement(arr, searchKey));
		
		searchKey = 57;
		System.out.println("Element " + searchKey + " is present at " + searchElement(arr, searchKey));

		searchKey = 21;
		System.out.println("Element " + searchKey + " is present at " + searchElement(arr, searchKey));
		
	}

}
