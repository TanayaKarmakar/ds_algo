package com.app.sorting.practice;

import java.util.Arrays;

public class TripletSumInArray {
	private static boolean findTripletSum(int[] arr, int sum) {
		Arrays.sort(arr);
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			if (isPairSum(arr, arr[i], i + 1, sum)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isPairSum(int[] arr, int item, int start, int sum) {
		int end = arr.length - 1;
		int diff = sum - item;
		while (start < end) {
			if (arr[start] + arr[end] == diff)
				return true;
			else if (arr[start] + arr[end] < diff)
				start++;
			else
				end--;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 45, 6, 10, 8 };
		System.out.println(findTripletSum(arr, 13));
	}

}
