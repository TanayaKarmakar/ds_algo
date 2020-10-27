package com.app.practice.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class RowComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		if(o1[1] == o2[1])
			return o1[0] - o2[0];
		return o2[1] - o1[1];
	}
	
}

public class KWeakestRowsLeetcode1337 {
	private static int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<int[]> pQ = new PriorityQueue<int[]>(new RowComparator());
		int m = mat.length;
		int n = mat[0].length;
		
		for(int i = 0; i < m; i++) {
			int count = 0;
			int j = 0;
			while(j < n && mat[i][j] == 1) {
				j++;
				count++;
			}
			int[] el = new int[] {i, (n - count)};
			pQ.add(el);
		}
		
		int[] res = new int[k];
		int j = 0;
		while(j < k && !pQ.isEmpty()) {
			res[j] = pQ.poll()[0];
			j++;
		}
		
		return res;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
		int k = 3;
		int[] res = kWeakestRows(mat, k);
		
		System.out.println(Arrays.toString(res));
	}

}
