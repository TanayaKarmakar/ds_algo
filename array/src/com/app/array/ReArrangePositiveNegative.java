package com.app.array;

import java.util.Arrays;

public class ReArrangePositiveNegative {
	private static void rearrangeArray(int[] arr) {
		int temp = 0;
		int n = arr.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		System.out.println(Arrays.toString(arr));

		int pos = i + 1;
		int neg = 0;

		while (pos < n && neg < pos && arr[neg] < 0) {
			int tmp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = tmp;
			neg += 2;
			pos++;
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		rearrangeArray(arr);
	}

}
