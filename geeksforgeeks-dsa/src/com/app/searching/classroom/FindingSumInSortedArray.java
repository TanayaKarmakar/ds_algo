package com.app.searching.classroom;

public class FindingSumInSortedArray {
	private static boolean findingSum(int[] arr, int x) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] + arr[end] == x) {
				System.out.println(arr[start] + " " + arr[end]);
//				start++;
//				end--;
				return true;
			} else if (arr[start] + arr[end] < x)
				start++;
			else
				end--;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 5, 6, 10, 14, 17, 20, 23 };
		findingSum(arr, 28);
		findingSum(arr, 11);
		findingSum(arr, 10);
	}

}
