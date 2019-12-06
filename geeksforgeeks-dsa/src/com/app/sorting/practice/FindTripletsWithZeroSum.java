package com.app.sorting.practice;

import java.util.Arrays;

public class FindTripletsWithZeroSum {
	private static int findTripletZeroSum(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;

		for (int i = 0; i < (n - 1); i++) {
			int item = arr[i];
			if (isZeroSumExists(arr, i + 1, item))
				return 1;
		}

		return 0;
	}

	private static boolean isZeroSumExists(int[] arr, int start, int item) {
		int end = arr.length - 1;

		while (start < end) {
			int sum = Math.abs(arr[start] + arr[end]);
			if(sum == Math.abs(item) && ((sum > 0 && item < 0) ||(sum < 0 && item > 0))) {
				return true;
			} else if(sum < Math.abs(item)) {
				start++;
			} else if(sum > Math.abs(item)){
				end--;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 0, -1, 2, -3, 1 };

		System.out.println(findTripletZeroSum(arr));
		
		arr = new int[]{1,2,3};
		
		System.out.println(findTripletZeroSum(arr));
		
		arr = new int[]{60, -65, 5, -21, 8, 93};
		
		System.out.println(findTripletZeroSum(arr));
	}

}
