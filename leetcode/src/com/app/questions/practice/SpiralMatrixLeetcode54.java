package com.app.questions.practice;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixLeetcode54 {
	private static List<Integer> spiralMatrix(int[][] matrix) {
		int nRow = matrix.length;
		int nCol = matrix[0].length;

		int top = 0;
		int bottom = nRow - 1;
		int left = 0;
		int right = nCol - 1;
		List<Integer> res = new ArrayList<>();

		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) {
				//System.out.print(matrix[top][i] + " ");
				res.add(matrix[top][i]);
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				//System.out.print(matrix[i][right] + " ");
				res.add(matrix[i][right]);
			}
			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					//System.out.print(matrix[bottom][i] + " ");
					res.add(matrix[bottom][i]);
				}
			}
			bottom--;

			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					//System.out.print(matrix[i][left] + " ");
					res.add(matrix[i][left]);
				}
			}
			left++;

		}
		//System.out.println();
		return res;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		List<Integer> res = spiralMatrix(mat);
		System.out.println(res);
	}

}
