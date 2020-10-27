package com.app.questions.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraversalOfMatrixLeetcode498 {
	private static int[] findDiagonalOrder(int[][] matrix) {
		TreeMap<Integer, List<Integer>> tMap = new TreeMap<>();

		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!tMap.containsKey(i + j))
					tMap.put(i + j, new ArrayList<>());
				tMap.get(i + j).add(matrix[i][j]);
			}
		}

		int totalEl = m * n;

		int[] res = new int[totalEl];
		boolean rev = true;
		int j = 0;
		for (Map.Entry<Integer, List<Integer>> entry : tMap.entrySet()) {
			if (rev) {
				Collections.reverse(entry.getValue());
			}
			for (Integer el : entry.getValue()) {
				res[j++] = el;
			}
			rev = !rev;
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
