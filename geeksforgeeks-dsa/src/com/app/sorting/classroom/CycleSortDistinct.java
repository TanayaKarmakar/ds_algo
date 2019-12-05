package com.app.sorting.classroom;

import java.util.Arrays;

public class CycleSortDistinct {
	private static void cycleSortDistinct(int[] arr) {
		int n = arr.length;

		for (int cs = 0; cs < n - 1; cs++) {
			int item = arr[cs];
			int pos = cs;

			for (int i = cs + 1; i < n; i++) {
				if (arr[i] < item) {
					pos++;
				}
			}

			if (pos == cs)
				continue;

			if (pos != cs) {
				int tmp = arr[pos];
				arr[pos] = item;
				item = tmp;
			}

			while (pos != cs) {
				pos = cs;

				for (int i = cs + 1; i < n; i++) {
					if (arr[i] < item) {
						pos++;
					}
				}

				int tmp = arr[pos];
				arr[pos] = item;
				item = tmp;

			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 5, 1, 3 };
		cycleSortDistinct(arr);

		System.out.println("After sorting, the array is ");
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {90,10,35,25,40,45};
		cycleSortDistinct(arr);
		
		System.out.println("After sorting, the array is ");
		System.out.println(Arrays.toString(arr));

	}

}
