package com.app.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {
	private static List<Integer> getSpiralOrder(int[][] matrix) {
		int n = matrix.length;
		List<Integer> result = new ArrayList<>();
		for (int offset = 0; offset < Math.ceil(0.5 * n); offset++) {
			fetchSpiralOrder(matrix, offset, result);
		}
		return result;
	}

	private static void fetchSpiralOrder(int[][] matrix, int offset, List<Integer> result) {
		// 1 X 1
		if (offset == (matrix.length - offset - 1)) {
			result.add(matrix[offset][offset]);
			return;
		}

		int size = matrix.length;
		for (int j = offset; j < (size - offset - 1); j++) {
			result.add(matrix[offset][j]);
		}

		for (int i = offset; i < (size - offset - 1); i++) {
			result.add(matrix[i][size - offset - 1]);
		}

		for (int j = (size - offset - 1); j > offset; j--) {
			result.add(matrix[size - offset - 1][j]);
		}

		for (int i = (size - offset - 1); i > offset; i--) {
			result.add(matrix[i][offset]);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		List<Integer> res = getSpiralOrder(matrix);

		System.out.println(res);

		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		res = getSpiralOrder(matrix);

		System.out.println(res);
	}

}
