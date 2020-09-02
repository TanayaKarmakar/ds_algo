package com.app.practice.array;

import java.util.Arrays;

public class RotateImageLeetcode48 {
	private static void rotate(int[][] matrix) {
		int n = matrix.length;

		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int[] tmp = matrix[start];
			matrix[start] = matrix[end];
			matrix[end] = tmp;
			start++;
			end--;
		}

		int i = 0;
		while (i < n) {
			int j = i;
			int k = i;
			while (j < n && k < n) {
				int tmp = matrix[i][k];
				matrix[i][k] = matrix[j][i];
				matrix[j][i] = tmp;
				j++;
				k++;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
		
		System.out.println(Arrays.deepToString(matrix));
	}

}
