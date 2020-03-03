package com.app.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortDiagonally {
	private static int[][] sortDiagonally(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		Map<Integer, List<Integer>> diffMap = new HashMap<>();
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				int diff = r - c;
				if (!diffMap.containsKey(diff)) {
					List<Integer> values = new ArrayList<>();
					values.add(mat[r][c]);
					diffMap.put(diff, values);
				} else {
					diffMap.get(diff).add(mat[r][c]);
				}
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : diffMap.entrySet()) {
			List<Integer> values = diffMap.get(entry.getKey());
			Collections.sort(values);
		}

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				int diff = r - c;
				mat[r][c] = diffMap.get(diff).get(0);
				diffMap.get(diff).remove(0);
			}
		}

		return mat;
	}

	public static void main(String[] args) {
		int[][] mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
		mat = sortDiagonally(mat);
		
		System.out.println(Arrays.deepToString(mat));
	}

}
