package com.app.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortTheMatrixDiagonallyLeetcode1329 {
	private static int[][] diagonalSort(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		TreeMap<Integer, List<Integer>> tMap = new TreeMap<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!tMap.containsKey(i - j)) {
					tMap.put(i - j, new ArrayList<>());
				}
				tMap.get(i - j).add(mat[i][j]);
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : tMap.entrySet()) {
			Collections.sort(entry.getValue());
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = tMap.get(i - j).remove(0);
			}
		}

		return mat;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
		
		matrix = diagonalSort(matrix);
		
		System.out.println(Arrays.deepToString(matrix));

	}

}
