package com.app.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortTheMatrixDiagonallyLeetcode1329 {
	private static int[][] diagonalSort(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		TreeMap<Integer, List<Integer>> tMap = new TreeMap<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int diff = (i - j);
				if (!tMap.containsKey(diff)) {
					tMap.put(diff, new ArrayList<>());
				}
				tMap.get(diff).add(matrix[i][j]);
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : tMap.entrySet()) {
			Collections.sort(entry.getValue());
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int diff = (i - j);
				matrix[i][j] = tMap.get(diff).remove(0);
			}
		}

		return matrix;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
		
		matrix = diagonalSort(matrix);
		
		System.out.println(Arrays.deepToString(matrix));

	}

}
