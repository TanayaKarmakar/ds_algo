package com.app.array;

import java.util.Arrays;

public class ReArrangePositiveNegativeOddEvenPos {
	// Hoare's partition
	private static void reArrange1(int[] arr) {
		int positive = 0;
		int negative = 1;
		int size = arr.length;
		while (true) {
			while (arr[negative] < 0 && negative < size)
				negative += 2;
			while (arr[positive] > 0 && positive < size)
				positive += 2;
			
			if(positive < size && negative < size) {
				int tmp = arr[positive];
				arr[positive] = arr[negative];
				arr[negative] = tmp;
			} else {
				break;
			}
		}
	}

	private static void reArrange(int[] arr) {
		int n = arr.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if ((arr[j] < 0 && j % 2 != 0) || (arr[j] > 0 && j % 2 == 0))
				continue;
			else {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}

		System.out.println("After rearrangement");
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 1, -3, 5, 6, -3, 6, 7, -4, 9, 10 };
		reArrange(arr);
		
		arr = new int[] {1, -3, 5, 6, -3, 6, 7, -4, 9, 10};
		reArrange1(arr);
		
		System.out.println("After arrangement");
		System.out.println(Arrays.toString(arr));
	}

}
