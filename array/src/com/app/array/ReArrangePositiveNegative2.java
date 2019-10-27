package com.app.array;

import java.util.Arrays;

public class ReArrangePositiveNegative2 {
	private static void reArrange(int[] arr) {
		int n = arr.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if(arr[j] > 0) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		System.out.println("After reArrangement, array is ");
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = {1 ,-1 ,-3 , -2, 7, 5, 11, 6};
		reArrange(arr);
	}

}
