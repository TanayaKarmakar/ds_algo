package com.array.ideserve;

public class BinarySearchInSortedRotatedArrayWithoutPivot {
	private static int searchElement(int[] arr, int searchKey) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = (start + end)/2;
			if(arr[mid] == searchKey)
				return mid;
			else if(arr[start] <= arr[mid]) {
				if(searchKey >= arr[start] && searchKey <= arr[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if(searchKey >= arr[mid] && searchKey <= arr[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 73, 85, 94, 21, 27, 34, 47, 54, 66 };
		int searchKey = 85;
		
		System.out.println("Element " + searchKey + " is present at " + searchElement(arr, searchKey));

	}

}
