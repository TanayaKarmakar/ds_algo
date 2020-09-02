package com.app.practice.array;

import java.util.Arrays;

class Pair implements Comparable<Pair> {
	int first;
	int second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int compareTo(Pair o) {
		int val = o.second - this.second;
		if (val == 0)
			return this.first - o.first;
		return val;
	}
}

public class KWeakestRowsLeetcode1337 {
	private static int[] kWeakestRows(int[][] matrix, int k) {
		int m = matrix.length;
		int n = matrix[0].length;

		Pair[] pairs = new Pair[m];

		for (int i = 0; i < m; i++) {
			int j = 0;
			int count = 0;
			while (j < n && matrix[i][j] == 1) {
				count++;
				j++;
			}
			Pair pair = new Pair(i, (n - count));
			pairs[i] = pair;
		}

		Arrays.sort(pairs);
		int[] res = new int[k];

		for (int i = 0; i < k; i++) {
			res[i] = pairs[i].first;
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
		int[] res = kWeakestRows(mat, 3);

		System.out.println(Arrays.toString(res));

		mat = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
		res = kWeakestRows(mat, 2);

		System.out.println(Arrays.toString(res));
	}

}
