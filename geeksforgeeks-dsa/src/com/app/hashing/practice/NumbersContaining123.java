package com.app.hashing.practice;

import java.util.Arrays;
import java.util.Scanner;

public class NumbersContaining123 {
	private static boolean containsDigit123(int number) {
		while (number != 0) {
			if (!(number % 10 == 1 || number % 10 == 2 || number % 10 == 3)) {
				return false;
			}
			number = number / 10;
		}
		return true;
	}

	private static String containsDigit(int[] arr) {
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (containsDigit123(arr[i])) {
				sb.append(arr[i] + " ");
			}
		}

		return (sb.toString() == null || sb.toString().isEmpty())? "-1" 
				: sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		StringBuilder sb = new StringBuilder();
		
		while (nTestCases > 0) {
			int nDim = scanner.nextInt();
			int[] arr = new int[nDim];

			for (int i = 0; i < nDim; i++) {
				arr[i] = scanner.nextInt();
			}
			sb.append(containsDigit(arr) + "\n");
			nTestCases--;
		}
		
		System.out.print(sb.toString());
		scanner.close();
	}

}
