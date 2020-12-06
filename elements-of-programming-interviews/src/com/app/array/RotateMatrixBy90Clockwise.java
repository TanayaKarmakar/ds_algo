package com.app.array;

import java.util.Arrays;

public class RotateMatrixBy90Clockwise {
	private static int[][] approach2(int[][] matrix) {
		int[][] tempMatrix = matrix.clone();
		int matrixSize = tempMatrix.length - 1;
		for (int i = 0; i < tempMatrix.length / 2; i++) {
			for (int j = i; j < (matrixSize - i); j++) {
				int tmp1 = tempMatrix[matrixSize - j][i];
				int tmp2 = tempMatrix[matrixSize - i][matrixSize - j];
				int tmp3 = tempMatrix[j][matrixSize - i];
				int tmp4 = tempMatrix[i][j];
				tempMatrix[i][j] = tmp1;
				tempMatrix[matrixSize - j][i] = tmp2;
				tempMatrix[matrixSize - i][matrixSize - j] = tmp3;
				tempMatrix[j][matrixSize - i] = tmp4;
			}
		}
		return tempMatrix;
	}

	// Time complexity O(n^2) + O(n)
	private static int[][] approach1(int[][] matrix) {
		int[][] tempMatrix = matrix.clone();
		int n = tempMatrix.length;

		int start = 0;
		int end = n - 1;
		while (start < end) {
			int[] tmp = tempMatrix[start];
			tempMatrix[start] = tempMatrix[end];
			tempMatrix[end] = tmp;
			start++;
			end--;
		}

		for (int i = 0; i < n; i++) {
			int k = i;
			int j = i;
			while (k < n && j < n) {
				int tmp = tempMatrix[i][j];
				tempMatrix[i][j] = tempMatrix[k][i];
				tempMatrix[k][i] = tmp;
				k++;
				j++;
			}
		}
		return tempMatrix;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		
//		System.out.println("Approach1");
//		System.out.println(Arrays.deepToString(approach1(matrix)));
	
	
		System.out.println("Approach2");
		System.out.println(Arrays.deepToString(approach2(matrix)));
	}

}
