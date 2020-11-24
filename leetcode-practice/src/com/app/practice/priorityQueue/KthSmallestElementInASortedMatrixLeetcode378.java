package com.app.practice.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrixLeetcode378 {
	private static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < k; i++) {
			int i1 = (i / n);
			int j1 = (i % n);
			pQ.add(matrix[i1][j1]);
		}

		for (int i = k; i < (n * n); i++) {
			int i1 = (i / n);
			int j1 = (i % n);
			if (pQ.peek() > matrix[i1][j1]) {
				pQ.poll();
				pQ.add(matrix[i1][j1]);
			}
		}

		return pQ.peek();
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		int ans = kthSmallest(matrix, 8);
		
		System.out.println(ans);
	}

}