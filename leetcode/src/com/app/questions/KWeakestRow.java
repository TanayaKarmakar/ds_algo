package com.app.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Row implements Comparable<Row> {
	int rowNum;
	int nSoldiers;

	public Row(int rowNum, int nSoldiers) {
		this.rowNum = rowNum;
		this.nSoldiers = nSoldiers;
	}

	@Override
	public int compareTo(Row that) {
		if (this.nSoldiers == that.nSoldiers) {
			return compareRows(this.rowNum, that.rowNum);
		} else if (this.nSoldiers < that.nSoldiers)
			return -1;
		else
			return 1;
	}

	private int compareRows(int row1, int row2) {
		if (row1 < row2)
			return -1;
		else if (row1 > row2)
			return 1;
		else
			return 0;
	}

}

public class KWeakestRow {
	private static int[] findKWeakestRow(int[][] mat, int k) {
		int n = mat.length;
		PriorityQueue<Row> pQ = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			int soldierCount = 0;
			int j = 0;
			while (j < mat[0].length && mat[i][j] != 0) {
				j++;
				soldierCount++;
			}

			pQ.add(new Row(i, soldierCount));
		}

		for (int i = k; i < n; i++) {
			int soldierCount = 0;
			int j = 0;
			while (j < mat[0].length && mat[i][j] != 0) {
				j++;
				soldierCount++;
			}
			if (pQ.peek().nSoldiers > soldierCount) {
				pQ.remove();
				pQ.add(new Row(i, soldierCount));
			}
		}

		int[] res = new int[k];
		int i = k - 1;
		while (!pQ.isEmpty()) {
			Row row = pQ.poll();
			res[i--] = row.rowNum;
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };

		int[] res = findKWeakestRow(mat, 3);

		System.out.println(Arrays.toString(res));

		mat = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };

		res = findKWeakestRow(mat, 2);
		
		System.out.println(Arrays.toString(res));
	
	}

}
