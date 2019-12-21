package com.app.matrix.practice;

//problem statement -
//Given a Square matrix mat[] of size NxN. 
// Your task is to find minimum number of operation(s) that are required 
//to make the matrix Beautiful.
//A Beautiful matrix is a matrix in which sum of elements in each row 
// and column is equal. In one operation you can only increment any value 
//of cell of matrix by 1.

public class BeautifulMatrix {
	private static int minOperation(int[][] mat) {
		int n = mat.length;
		int[] sumRow = new int[n];
		int[] sumCol = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sumRow[i] += mat[i][j];
				sumCol[j] += mat[i][j];
			}
		}

		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			maxSum = Integer.max(sumRow[i], maxSum);
			maxSum = Integer.max(sumCol[i], maxSum);
		}

		int count = 0;
		int diff = 0;

		for (int i = 0, j = 0; i < n && j < n;) {
			diff = Integer.min(maxSum - sumRow[i], maxSum - sumCol[j]);

			mat[i][j] += diff;
			sumRow[i] += diff;
			sumCol[j] += diff;

			count += diff;

			if (sumRow[i] == maxSum)
				++i;

			if (sumCol[j] == maxSum)
				++j;
		}

		return count;

	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2 }, { 3, 4 } };
		System.out.println("Min operation needed - " + minOperation(mat));

		mat = new int[][] { { 1, 2, 3 }, { 4, 2, 3 }, { 3, 2, 1 } };
		System.out.println("Min operation needed - " + minOperation(mat));

	}

}
