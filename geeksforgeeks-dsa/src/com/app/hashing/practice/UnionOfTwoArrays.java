package com.app.hashing.practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionOfTwoArrays {
	private static int unionArrays(int[] arr1, int[] arr2) {
		Set<Integer> numSet = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			numSet.add(arr1[i]);
		}

		for (int i = 0; i < arr2.length; i++) {
			numSet.add(arr2[i]);
		}

		return numSet.size();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		StringBuilder sb = new StringBuilder();

		while (nTestCases > 0) {
			int nDim1 = scanner.nextInt();
			int nDim2 = scanner.nextInt();
			int[] arr1 = new int[nDim1];
			for (int i = 0; i < nDim1; i++) {
				arr1[i] = scanner.nextInt();
			}

			int[] arr2 = new int[nDim2];
			for (int i = 0; i < nDim2; i++) {
				arr2[i] = scanner.nextInt();
			}

			sb.append(unionArrays(arr1, arr2) + "\n");

			nTestCases--;
		}
		System.out.println(sb.toString());
		scanner.close();
	}

}
