package com.app.array;

import java.util.Arrays;

//Rearrange array such that even positioned are greater than odd

//this question means
//1st even index should contain the greatest number
//next even index should contain the next greatest number and so on
public class ReArrangeArrayEvenIndexGreaterNumber {
	private static void reArrangeArray(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		int p = 0;
		int q = n - 1;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			if((i + 1) % 2 == 0) {
				res[i] = arr[q--];
			} else {
				res[i] = arr[p++];
			}
		}
		
		System.out.println("Final array ");
		System.out.println(Arrays.toString(res));
	}

	public static void main(String[] args) {
		int[] arr = {87, 78, 16, 94, 36, 87, 93, 50, 22, 63, 28, 
				91, 60, 64, 27, 41, 27, 73, 37, 12, 69, 68, 30, 83, 
				31, 63, 24, 68, 36, 30, 3, 23, 59, 70, 68, 94, 57, 
				12, 43, 30, 74, 22, 20, 85, 38, 99, 25, 16, 71, 14, 
				27, 92, 81, 57, 74, 63, 71, 97, 82, 6, 26, 85, 28, 37,
				6, 47, 30, 14, 58, 25, 96, 83, 46, 15, 68, 35, 65, 44,
				51, 88, 9, 77, 79, 89};
		
		reArrangeArray(arr);

	}

}
