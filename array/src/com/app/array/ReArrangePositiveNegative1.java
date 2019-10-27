package com.app.array;

import java.util.Arrays;

//Rearrange positive and negative numbers with constant extra space
public class ReArrangePositiveNegative1 {

	//inesrtion sort approach
	private static void reArrange1(int[] arr) {
		int n = arr.length;
		int key = 0;
		int j = 0;
		for (int i = 1; i < n; i++) {
			key = arr[i];
			if (key < 0) {
				j = i - 1;
				while (j >= 0 && arr[j] > 0) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = key;
			}
		}
	}

	// quicksort like approach but it changes the relative order of the elements
	private static void reArrange(int[] arr) {
		int n = arr.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { -13, 11, 12, -5, 6, -7, 5, -3, -6 };
		reArrange(arr);
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {-12, 11, -13, -5, 6, -7, 5, -3, -6};
		reArrange1(arr);
		System.out.println(Arrays.toString(arr));
	}

}
