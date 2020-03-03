package com.app.prereq.problems;

import java.util.Scanner;

public class SumArray {
	private static boolean canAdd(int[][] mat, int rowIndx, int colIndx, int n) {
		return (rowIndx == 0 || rowIndx == n - 1 || colIndx == 0 || colIndx == n - 1 
				|| rowIndx == colIndx
				|| (rowIndx + colIndx) == n - 1);
	}

	private static int findSum(int[][] mat, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (canAdd(mat, i, j, n)) {
					sum += mat[i][j];
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = Integer.parseInt(scanner.nextLine());

		int[][] mat = new int[nDim][nDim];
		for (int i = 0; i < nDim; i++) {
			String str = scanner.nextLine();
			int indx = 0;
			for (String el : str.split("\\s+")) {
				mat[i][indx++] = Integer.parseInt(el);
			}
		}
		
		int sum = findSum(mat, nDim);
		System.out.println(sum);
		scanner.close();
	}
}
