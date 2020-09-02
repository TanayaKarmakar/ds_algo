package com.app.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class RowComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		if (o1[1] == o2[1])
			return o1[0] - o2[0];
		return o2[1] - o1[1];
	}

}

public class KWeakestRowInAMatrixLeetcode1337 {
	private static int[] getKWeakestRow(int[][] mat, int k) {
		PriorityQueue<int[]> pQ = new PriorityQueue<>(new RowComparator());
		int m = mat.length;
		int n = mat[0].length;
		for (int i = 0; i < m; i++) {
			int j = 0;
			int count = 0;
			while (j < n && mat[i][j] == 1) {
				count++;
				j++;
			}
			int[] val = new int[2];
			val[0] = i;
			val[1] = (n - count);
			pQ.add(val);
		}

		int[] res = new int[k];
		int i = 0;
		while (!pQ.isEmpty() && i < k) {
			int[] item = pQ.poll();
			res[i++] = item[0];
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 },
				{ 1, 1, 1, 1, 1 } };
		
		System.out.println(Arrays.toString(getKWeakestRow(grid, 3)));

	}

}
