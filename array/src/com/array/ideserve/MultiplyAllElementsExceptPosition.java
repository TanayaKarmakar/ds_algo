package com.array.ideserve;

import java.util.Arrays;

// lets that there is an array that contains {1,2,3,4}
// update each element in the array such that each element
//contains number which is multiplication of all the element 
// from all position except that position
public class MultiplyAllElementsExceptPosition {
	private static int[] multiplyNumbers(int[] arr) {
		int n = arr.length;
		int[] leftRight = new int[n];
		int left = 1;

		for (int i = 0; i < n; i++) {
			leftRight[i] = left;
			left = left * arr[i];
		}

		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			leftRight[i] = leftRight[i] * right;
			right = right * arr[i];
		}

		return leftRight;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		System.out.println(Arrays.toString(multiplyNumbers(arr)));
	}

}
