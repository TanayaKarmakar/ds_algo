package com.app.searching.practice;

import java.io.IOException;

public class CountDuplicates {
	private static int findDuplicateItem(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			int mid = low + (high - low)/2;
			if((mid - 1 >= 0 && arr[mid] == arr[mid - 1]) || (mid + 1 < arr.length && arr[mid] == arr[mid + 1]))
				return arr[mid];
			else if((arr[mid] - arr[0]) < mid)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return 0;
	}
	private static String countDuplicates(int[] arr) {
		int n = arr.length;
		int nDuplicate = n - (arr[n - 1] - arr[0]);
		int elem = findDuplicateItem(arr);
		return elem + " " + nDuplicate;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println(countDuplicates(new int[] {1,2,3,3,4}));
	}

}
