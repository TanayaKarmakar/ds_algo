package com.app.array.classroom;

import java.util.Arrays;

public class NBonacciNumbers {
	private static int[] nBonacciNumbers(int n, int m) {
		if (n > m)
			return null;
		int[] arr = new int[m];

		int i = 0;
		int start = 0;
		while (i < (n - 1)) {
			arr[i] = 0;
			i++;
		}
		arr[i] = 1;

		int sum = arr[i++];
		while (i < m) {
			arr[i] = sum;
			sum += (arr[i] - arr[start]);
			start++;
			i++;
		}

		return arr;
	}

	public static void main(String[] args) {
		System.out.println("NBonacci - " + Arrays.toString(nBonacciNumbers(3, 8)));
		System.out.println("NBonacci - " + Arrays.toString(nBonacciNumbers(4, 10)));
		System.out.println("NBonacci - " + Arrays.toString(nBonacciNumbers(5, 15)));
	}

}
