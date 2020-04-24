package com.app.questions.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

class RowItem implements Comparable<RowItem> {
	int rowNum;
	int count;

	@Override
	public int compareTo(RowItem o) {
		if (this.count > o.count)
			return -1;
		else if (this.count < o.count)
			return 1;
		else {
			if (this.rowNum < o.rowNum)
				return -1;
			else if (this.rowNum > o.rowNum)
				return 1;
			else
				return 0;
		}
	}
}

public class KWeakestRowsLeetcode1337 {
	private static int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<RowItem> pQ = new PriorityQueue<>();
		for (int i = 0; i < mat.length; i++) {
			int j = 0;
			int count = 0;
			while(j < mat[0].length && mat[i][j] != 0) {
				j++;
				count++;
			}
			RowItem item = new RowItem();
			item.rowNum = i;
			item.count = mat[0].length - count;
			pQ.add(item);
		}

		int[] res = new int[k];
		int i = 0;
		while(!pQ.isEmpty() && i < k) {
			res[i++] = pQ.poll().rowNum;
		}
		
		return res;
		
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };

		System.out.println(Arrays.toString(kWeakestRows(mat, 3)));

		mat = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };

		System.out.println(Arrays.toString(kWeakestRows(mat, 2)));

		mat = new int[][] { { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 1 } };
		
		System.out.println(Arrays.toString(kWeakestRows(mat, 4)));
	}

}
