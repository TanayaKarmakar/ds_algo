package com.app.practice;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderLeetcode54 {
	private static List<Integer> spiralOrder(int[][] matrix) {
		if(matrix.length == 0)
            return new ArrayList<>();
		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		
		int n = (matrix.length) * (matrix[0].length);

		List<Integer> res = new ArrayList<>();
		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) {
				res.add(matrix[top][i]);
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				res.add(matrix[i][right]);
			}

			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					res.add(matrix[bottom][i]);
				}
			}
			bottom--;

			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					res.add(matrix[i][left]);
				}
			}
			left++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		List<Integer> res = spiralOrder(matrix);
		
		System.out.println(res);
		

	}

}
