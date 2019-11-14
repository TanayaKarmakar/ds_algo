package com.app.array.classroom;

import java.util.Scanner;

public class DivideArrayInThreePartsEqualSum {
	private static boolean canDivideIn3(int[] arr) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		if (sum % 3 != 0)
			return false;

		int leftSum = 0;
		int firstPartIndx = -1;
		for (int i = 0; i < n; i++) {
			sum -= arr[i];
			leftSum += arr[i];
			if (sum == 2 * leftSum) {
				firstPartIndx = (i + 1);
				break;
			}
		}
		if (firstPartIndx == -1)
			return false;

		leftSum = 0;
		for (int i = firstPartIndx; i < n; i++) {
			sum -= arr[i];
			leftSum += arr[i];
			if (leftSum == sum)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = { 6, 1, 5, 2, 1, 1, 5 };
		System.out.println("Can divide in 3 " + canDivideIn3(arr));

		arr = new int[] { 11, 9, 17, 1, 2, 3, 1, 3, 3, 6, 4 };
		System.out.println("Can divide in 3 " + canDivideIn3(arr));

		arr = new int[] { 4, 3, 2, 1, 5, 6 };
		System.out.println("Can divide in 3 " + canDivideIn3(arr));
	}

}
