package com.app.array;

import java.util.Arrays;

// Given an array of integers, update every element with multiplication of previous 
// and next elements with following exceptions.
//a) First element is replaced by multiplication of first and second.
//b) Last element is replaced by multiplication of last and second last.
public class ReplaceArrayWithElements {
	private static void reArrange(int[] arr) {
		int n = arr.length - 1;
		int prev = arr[0];
		int temp = 0;
		for (int i = 0; i <= n; i++) {
			temp = arr[i];
			if((i + 1) < n) {
				arr[i] = prev * arr[i + 1];
			} else {
				arr[i] = prev * arr[i];
			}
			prev = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 5, 6 };
		System.out.println("Before modication");
		System.out.println(Arrays.toString(arr));
		reArrange(arr);
		System.out.println("After Modification");
		System.out.println(Arrays.toString(arr));
	}

}
