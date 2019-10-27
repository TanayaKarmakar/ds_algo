package com.array.ideserve;

import java.util.Arrays;

//Problem statement :- you have a number (say 1234) represented as array of digits
// you need to find the next higher number using same digits
public class NextHigherNumber {
	private static void nextHigherNumber(int[] arr) {
		int d1 = 0;
		int d2 = 0;

		int n = arr.length - 1;
		for (int i = n; i >= 0; i--) {
			if ((i - 1) >= 0) {
				if (arr[i] > arr[i - 1]) {
					d1 = (i - 1);
					break;
				}
			}
		}

		for (int i = d1 + 1; i <= n; i++) {
			if(arr[i] > arr[d1]) {
				d2 = i;
			}
		}

//		System.out.println(arr[d1]);
//		System.out.println(arr[d2]);
		
		int tmp = arr[d1];
		arr[d1] = arr[d2];
		arr[d2] = tmp;
		
		
		int i = d1 + 1;
		int j = n;
		
		while(i < j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
		
		
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		nextHigherNumber(new int[] { 1, 2, 3, 4 });
		nextHigherNumber(new int[] { 3, 2, 8, 4, 1 });

	}

}
