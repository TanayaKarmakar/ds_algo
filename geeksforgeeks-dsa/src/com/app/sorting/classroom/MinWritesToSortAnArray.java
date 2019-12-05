package com.app.sorting.classroom;

import java.util.Arrays;

public class MinWritesToSortAnArray {
	private static int findMinSwaps(int[] arr) {
		int writes = 0;
		int pos = 0;

		int n = arr.length;
		int item = 0;

		for (int cs = 0; cs < (n - 1); cs++) {
			pos = cs;
			item = arr[cs];

			for (int i = cs + 1; i < n; i++) {
				if (arr[i] < item) {
					pos++;
				}
			}

			if (pos == cs)
				continue;
			
			while(arr[pos] == item)
				pos++;

			if (pos != cs) {
				int tmp = arr[pos];
				arr[pos] = item;
				item = tmp;
				writes++;
			}

			while (pos != cs) {
				pos = cs;

				for (int i = cs + 1; i < n; i++) {
					if (arr[i] < item) {
						pos++;
					}
				}
				
				while(arr[pos] == item)
					pos++;

				if (arr[pos] != item) {
					int tmp = arr[pos];
					arr[pos] = item;
					item = tmp;
					writes++;
				}
			}

		}
		
		return writes;

	}

	public static void main(String[] args) {
		int[] arr = { 10, 1, 2, -1, 10, 5, 1, 8, 7, 6, 5 };
		
		int minSwaps = findMinSwaps(arr);
		
		System.out.println("After sorting, the array is ");
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Minimum number of swaps needed " + minSwaps);
		
		arr = new int[]{4,3,2,1};
		minSwaps = findMinSwaps(arr);
		
		System.out.println("After sorting the array is ");
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Minimum number of swaps needed " + minSwaps);
	}

}
