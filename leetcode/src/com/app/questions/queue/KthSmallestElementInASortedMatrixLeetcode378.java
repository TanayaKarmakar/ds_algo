package com.app.questions.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrixLeetcode378 {
	private static int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		int m = matrix.length;
		int n = matrix[0].length;

		int t = m * n;

		for (int i1 = 0; i1 < k; i1++) {
			int i = (i1 / n);
			int j = (i1 % n);
			pQ.add(matrix[i][j]);
		}

		for (int i1 = k; i1 < t; i1++) {
			int i = (i1 / n);
			int j = (i1 % n);
			if (pQ.peek() > matrix[i][j]) {
				pQ.poll();
				pQ.add(matrix[i][j]);
			}
		}

		return pQ.peek();
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		int k = 8;
		int ans = kthSmallest(matrix, k);

		System.out.println(ans);

	}

}
