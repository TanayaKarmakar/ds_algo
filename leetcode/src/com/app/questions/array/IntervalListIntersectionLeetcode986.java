package com.app.questions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersectionLeetcode986 {
	private static int[][] intervalIntersection(int[][] A, int[][] B) {
		if (A == null || A.length == 0 || B == null || B.length == 0)
			return new int[][] {};
		List<int[]> list = new ArrayList<>();

		int m = A.length;
		int n = B.length;

		int aIndx = 0;
		int bIndx = 0;
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
		for (int[] el : list) {
			res[i++] = el;
		}
		
		return res;
	}

	public static void main(String[] args) {
		int[][] A = { { 4, 6 }, { 7, 8 }, { 10, 17 } };
		int[][] B = { { 5, 10 } };

		int[][] res = intervalIntersection(A, B);

		System.out.println(Arrays.deepToString(res));

	}

}
