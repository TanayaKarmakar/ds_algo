package com.app.questions;

import java.util.Arrays;

public class RotateImage {
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
			int nxt = (i + 1);
			while (nxt < n) {
				int tmp = matrix[i][nxt];
				matrix[i][nxt] = matrix[nxt][i];
				matrix[nxt][i] = tmp;
				nxt++;
			}
			i++;
		}

		System.out.println(Arrays.deepToString(matrix));
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		rotate(mat);

	}

}
