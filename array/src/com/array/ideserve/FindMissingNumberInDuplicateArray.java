package com.array.ideserve;

public class FindMissingNumberInDuplicateArray {
	private static int findMissingNumberUsingXORApproach(int[] array1, int[] array2) {
		int result = array1[0];
		for (int i = 1; i < array1.length; i++) {
			result = result ^ array1[i];
		}
		for (int i = 0; i < array2.length; i++) {
			result = result ^ array2[i];
		}
		return result;
	}

	private static int findMissingNumberUsingSumApproach(int[] array1, int[] array2) {
		int result = array1[0];
		for (int i = 1; i < array1.length; i++) {
			result += array1[i];
		}
		for (int i = 0; i < array2.length; i++) {
			result -= array2[i];
		}
		return result;
	}

	private static int findMissingNumber(int[] array1, int[] array2) {
		if (array1.length == 0 && array2.length == 0) {
			System.out.println("Invalid input");
			return -1;
		} else if (array1.length == 0) {
			if (array2.length == 1) {
				return array2[0];
			} else {
				System.out.println("Invalid Input");
				return -1;
			}
		} else if (array2.length == 0) {
			if (array1.length == 1) {
				return array1[0];
			} else {
				System.out.println("Invalid Input");
				return -1;
			}
		} else {
			if (array1.length > array2.length) {
				return findMissingNumberUsingSumApproach(array1, array2);
				//return findMissingNumberUsingXORApproach(array1, array2);
			} else {
				return findMissingNumberUsingSumApproach(array2, array1);
				//return findMissingNumberUsingXORApproach(array2, array1);
			}
		}
	}

	public static void main(String[] args) {
		int[] array1 = { 9, 7, 8, 5, 4, 6, 2, 3, 1 };
		int[] array2 = { 2, 3, 4, 9, 1, 8, 5, 6 };

		System.out.println("Missing Number - " + findMissingNumber(array1, array2));
	}

}
