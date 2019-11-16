package com.app.array.practice;

public class SortedAndRotated {
	public static boolean checkIfSortedAndRotated(int[] arr) {
		int minIndx = -1;
		int maxIndx = -1;
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;

		int n = arr.length;

		for (int i = 0; i < n; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
				maxIndx = i;
			}
			if (arr[i] < minVal) {
				minVal = arr[i];
				minIndx = i;
			}
		}

		// array is sorted but not rotated
		if ((minIndx == 0 && maxIndx == n - 1) || (minIndx == n - 1 && maxIndx == 0))
			return false;
		if (Math.abs(maxIndx - minIndx) != 1)
			return false;

		// for increasingly sorted element
		if (maxIndx + 1 == minIndx) {
			int i = minIndx + 1;
			while (i <= maxIndx) {
				if (arr[i - 1] > arr[i])
					return false;
				i = (i + 1) % n;
			}
			if(arr[0] < arr[n - 1])
				return false;
		}
		if (minIndx + 1 == maxIndx) {// for decreasingly sorted element
			int i = maxIndx + 1;
			while (i <= minIndx) {
				if (arr[i - 1] < arr[i])
					return false;
				i = (i + 1) % n;
			}
			if(arr[0] > arr[n - 1])
				return false;
		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println(checkIfSortedAndRotated(new int[] { 10, 20, 30, 14 }));
		System.out.println(checkIfSortedAndRotated(new int[] { 10, 20, 30, 50 }));
		System.out.println(checkIfSortedAndRotated(new int[] { 30, 20, 10, 50, 35 }));
		System.out.println(checkIfSortedAndRotated(new int[] { 30, 20, 10, 50, 25 }));
		System.out.println(checkIfSortedAndRotated(new int[] { 30, 40, 10, 20 }));
	}

}
