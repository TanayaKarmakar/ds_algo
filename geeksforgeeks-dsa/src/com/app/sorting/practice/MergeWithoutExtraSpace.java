package com.app.sorting.practice;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
	private static int nextGap(int gap) {
		if(gap <= 1)
			return 0;
		return (gap / 2) + (gap % 2);
	}

	private static void mergeWithoutExtraSpace(int[] arr1, int[] arr2) {
		int m = arr1.length;
		int n = arr2.length;

		int total = m + n;
		int i, j;

		for (int gap = nextGap(total); gap >= 1; gap = nextGap(gap)) {
			for (i = 0; i + gap < m; i++) {
				if (arr1[i] > arr1[i + gap]) {
					swap(arr1, i + gap, i);
				}
			}

			for (j = gap > m ? gap - m : 0; i < m && j < n; i++, j++) {
				if(arr1[i] > arr2[j]) {
					swap(arr1, arr2, i, j);
				}
			}
			
			if(j < n) {
				for(j = 0;j+gap<n;j++) {
					if(arr2[j] > arr2[j + gap]) {
						swap(arr2, j + gap, j);
					}
				}
			}
		}

//		for (int gap = total / 2; gap >= 1; gap = gap / 2) {
//			for (int j = gap; j < total; j++) {
//				for (int i = j - gap; i >= 0; i = i - gap) {
//					if (i < m - 1 && (i + gap) <= m - 1) {
//						if (arr1[i + gap] > arr1[i]) {
//							break;
//						} else {
//							swap(arr1, i + gap, i);
//						}
//					} else if (i <= m - 1 && (i + gap) > m - 1) {
//						int pos = (i + gap) - m;
//						if (arr2[pos] > arr1[i]) {
//							break;
//						} else {
//							swap(arr1, arr2, i, pos);
//						}
//					} else {
//						i = (i - m);
//						//i = i - m;
//						if (i + gap < n) {
//							if (arr2[i + gap] > arr2[i]) {
//								break;
//							} else {
//								swap(arr2, i + gap, i);
//							}
//						}
//					}
//				}
//			}
//		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void swap(int[] arr1, int[] arr2, int i, int j) {
		int tmp = arr1[i];
		arr1[i] = arr2[j];
		arr2[j] = tmp;

	}

	public static void main(String[] args) {
//		int[] arr = { 1, 5, 9, 10, 15, 20 };
//		int[] arr1 = { 2, 3, 8, 13 };
//
//		mergeWithoutExtraSpace(arr, arr1);
//
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arr1));
//
//		arr = new int[] { 10 };
//		arr1 = new int[] { 2, 3 };
//		mergeWithoutExtraSpace(arr, arr1);
//
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arr1));

		int[] arr = new int[] { 34, 101, 130, 138, 183, 184, 209, 211, 352, 358, 365, 469, 469, 484 };
		int[] arr1 = new int[] { 13, 84, 88, 141, 142, 185, 193, 202, 233, 257, 370, 438, 500 };
		mergeWithoutExtraSpace(arr, arr1);

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr1));
	}

}
