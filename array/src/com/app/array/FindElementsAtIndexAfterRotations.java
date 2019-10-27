package com.app.array;

public class FindElementsAtIndexAfterRotations {
	private static int findElementAtIndex(int[] arr, int[][] ranges, int index) {
		int rotations = ranges.length;
		for (int i = rotations - 1; i >= 0; i--) {
			int left = ranges[i][0];
			int right = ranges[i][1];

			if (index >= left && index <= right) {
				if (index == left) {
					index = right;
				} else {
					index--;
				}
			}
		}
		return arr[index];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int[][] ranges = { { 0, 2 }, { 0, 3 } };
		int index = 1;
		int element = findElementAtIndex(arr, ranges, index);
		System.out.println("Element at index " + index + " is " + element);
	}

}
