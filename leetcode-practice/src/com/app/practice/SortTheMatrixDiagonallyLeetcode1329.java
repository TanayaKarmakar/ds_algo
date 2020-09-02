package com.app.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortTheMatrixDiagonallyLeetcode1329 {
	private static int[][] diagonalSort(int[][] mat) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int m = mat.length;
		int n = mat[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!map.containsKey(i - j)) {
					List<Integer> item = new ArrayList<>();
					item.add(mat[i][j]);
					map.put(i - j, item);
				} else {
					map.get(i - j).add(mat[i][j]);
				}
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = map.get(i - j).remove(0);
			}
		}
		return mat;
	}

	public static void main(String[] args) {
		int[][] mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
		mat = diagonalSort(mat);

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
