package com.app.searching.classroom;

public class CountOccurrences {
	private static int findLeftMostIndex(int[] arr, int x) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == x && (mid == 0 || arr[mid - 1] != x)) {
				return mid;
			} else if (arr[mid] >= x)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	private static int findRightMostIndex(int[] arr, int x) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == x && (mid == arr.length - 1 || arr[mid + 1] != x))
				return mid;
			else if (arr[mid] > x)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	private static int countOccurencesEfficient(int[] arr, int x) {
		// find leftmost index
		// find rightmost index
		// return the difference
		int leftMostIndx = findLeftMostIndex(arr, x);
		int rightMostIndx = findRightMostIndex(arr, x);

		if(rightMostIndx == -1 || leftMostIndx == -1)
			return 0;
		return (rightMostIndx - leftMostIndx) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Frequency - " + countOccurencesEfficient(new int[] { 2, 3, 3, 3, 3, 5 }, 3));
		System.out.println("Frequency - " + countOccurencesEfficient(new int[] { 2, 3, 3, 3, 3, 5 }, 5));
		System.out.println("Frequency - " + countOccurencesEfficient(new int[] { 2, 3, 3, 3, 3, 5 }, 2));
		System.out.println("Frequency - " + countOccurencesEfficient(new int[] { 2, 3, 3, 3, 3, 5, 5 }, 5));
		System.out.println("Frequency - " + countOccurencesEfficient(new int[] { 2, 3, 3, 3, 3, 5, 5 }, 2));
		System.out.println(
				"Frequency - " + countOccurencesEfficient(new int[] { 2, 3, 3, 3, 3, 5, 5, 6, 6, 6, 6, 8 }, 6));
	}

}
