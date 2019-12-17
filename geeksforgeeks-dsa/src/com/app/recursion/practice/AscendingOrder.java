package com.app.recursion.practice;

public class AscendingOrder {
	private static boolean checkIfAscending(int[] arr, int indx) {
		if (arr.length == 1 || indx == arr.length - 1)
			return true;
		else
			return arr[indx] <= arr[indx + 1] 
					&& checkIfAscending(arr, indx + 1);
	}

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 10, 11, 4 };

		System.out.println(checkIfAscending(arr, 0));

		arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 8 };
		System.out.println(checkIfAscending(arr, 0));

		arr = new int[] { 1, 2, 3, 4 };
		System.out.println(checkIfAscending(arr, 0));

	}

}
