package com.app.recursion.practice;

public class LinearSearch {
	private static int searchNumber(int[] arr, int start, int end, int key) {
		if (start <= end) {
			if (arr[start] == key)
				return start;
			else
				return searchNumber(arr, start + 1, end, key);
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 3, -1, 5, 10, 9, 19, 14, 12, 8 };
		System.out.println("Number present at index " + 
		        searchNumber(arr, 0, arr.length - 1, 8));
		
		System.out.println("Number present at index " + 
		        searchNumber(arr, 0, arr.length - 1, 11));


	}

}
