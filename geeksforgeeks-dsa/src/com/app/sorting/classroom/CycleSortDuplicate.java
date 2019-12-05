package com.app.sorting.classroom;

import java.util.Arrays;

public class CycleSortDuplicate {

	private static void cycleSortDuplicate(int[] arr) {
		int n = arr.length;
		int pos = 0;
		int tmp = 0;

		for (int cs = 0; cs < (n - 1); cs++) {
			int item = arr[cs];
			pos = cs;

			for (int i = cs + 1; i < n; i++) {
				if (arr[i] < item) {
					pos++;
				}
			}

			if (pos == cs)
				continue;

			while (item == arr[pos])
				pos++;

			if(pos != cs) {
				tmp = item;
				item = arr[pos];
				arr[pos] = tmp;
			}
			

			while (pos != cs) {
				pos = cs;

				for (int i = cs + 1; i < n; i++) {
					if (arr[i] < item) {
						pos++;
					}
				}

				while (item == arr[pos])
					pos++;

				if(item != arr[pos]) {
					tmp = item;
					item = arr[pos];
					arr[pos] = tmp;
				}	
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 1, 2, -1, 10, 5, 1, 8, 7, 6, 5 };
		cycleSortDuplicate(arr);
		//cycleSortGFG(arr);
		
		System.out.println("After sorting, the array is");
		System.out.println(Arrays.toString(arr));

	}

}
