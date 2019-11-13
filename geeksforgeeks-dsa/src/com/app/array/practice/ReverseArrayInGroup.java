package com.app.array.practice;

import java.util.Arrays;

public class ReverseArrayInGroup {
	private static void reverseArrayInGroup(int[] arr, int k) {
		int start = 0;
		int end = start + (k - 1);
		int n = arr.length;
		while (start < end && end < n) {
			reverseArray(arr, start, end);
//			if(end + 1 < n) {
				start = end + 1;
			//}
			
			if (start + (k - 1) > (n - 1)) {
				break;
			}
			end = start + (k - 1);
		}
		System.out.println(start);
		reverseArray(arr, start, n - 1);
	}

	private static void reverseArray(int[] arr, int start, int end) {
		while (start <= end) {
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8};
		reverseArrayInGroup(arr, 3);
		
		System.out.println(Arrays.toString(arr));
	}

}
