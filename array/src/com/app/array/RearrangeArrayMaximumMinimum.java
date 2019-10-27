package com.app.array;

import java.util.Arrays;

public class RearrangeArrayMaximumMinimum {
	private static void reArrangeArray1(int[] arr) {
		int n = arr.length;
		int min = 0;
		int max = (n - 1);
		int largest = arr[n - 1] + 1;

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				arr[i] = (arr[max] % largest) * largest + arr[i];
				max--;
			} else {
				arr[i] = (arr[min] % largest) * largest + arr[i];
				min++;
			}
		}

		for (int i = 0; i < n; i++) {
			arr[i] /= largest;
		}
	}

	private static void reArrangeArray(int[] arr) {
		int n = arr.length;
		int[] temp = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (count < n) {
				temp[count] = arr[i];
			}

			if ((count + 1) < n) {
				temp[count + 1] = arr[n - 1 - i];
			}
			count += 2;
		}

		for (int indx = 0; indx < n; indx++) {
			arr[indx] = temp[indx];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Before rearrangement");
		System.out.println(Arrays.toString(arr));

		reArrangeArray(arr);

		System.out.println("After rearrangement");
		System.out.println(Arrays.toString(arr));

		arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Before rearrangement");
		System.out.println(Arrays.toString(arr));

		reArrangeArray1(arr);

		System.out.println("After rearrangement");
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {1,2,3,4,5,6};
		System.out.println("Before rearrangement");
		System.out.println(Arrays.toString(arr));
		
		reArrangeArray1(arr);
		
		System.out.println("After rearrangement");
		System.out.println(Arrays.toString(arr));

	}

}
