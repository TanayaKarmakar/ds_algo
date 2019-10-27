package com.app.array;

import java.util.Arrays;

//Rearrange an array such that ‘arr[j]’ becomes ‘i’ if ‘arr[i]’ is ‘j’
public class ArrayRearrangment {
	private static void exchangeArray(int[] arr) {
		int n = arr.length;
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			if (arr[i] == i) {
				temp[i] = i;
			} else {
				temp[arr[i]] = i;
			}
		}

		for (int i = 0; i < n; i++) {
			arr[i] = temp[i];
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 0, 2 };
		System.out.println("Before exchange");
		System.out.println(Arrays.toString(arr));
		exchangeArray(arr);
		System.out.println("After exchange");
		System.out.println(Arrays.toString(arr));
	}

}
