package com.app.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersectionLeetcode986 {
	private static int[][] intervalIntersection(int[][] A, int[][] B) {
		int m = A.length;
		int n = B.length;
		int aIndx = 0;
		int bIndx = 0;

		List<int[]> list = new ArrayList<>();

		while (aIndx < m && bIndx < n) {
			int start = Integer.max(A[aIndx][0], B[bIndx][0]);
			int end = Integer.min(A[aIndx][1], B[bIndx][1]);

			if (start <= end) {
				list.add(new int[] { start, end });
			}

			if (A[aIndx][1] < B[bIndx][1])
				aIndx++;
			else
				bIndx++;
		}

		int[][] res = new int[list.size()][];

		int i = 0;
		for (int[] item : list) {
			res[i++] = item;
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] A = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] B = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
		
		int[][] res = intervalIntersection(A, B);
		
		System.out.println(Arrays.deepToString(res));

	}

}
