package com.app.stack.practice;

import java.util.Stack;

public class CelebrityProblem {
	private static boolean knows(int[][] mat, int a, int b) {
		return mat[a][b] == 1;
	}

	private static int findCelebrity(int[][] mat, int n) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			stack.push(i);
		}

		while (stack.size() > 1) {
			int a = stack.pop();
			int b = stack.pop();

			if (knows(mat, a, b)) {
				stack.push(b);
			} else {
				stack.push(a);
			}
		}

		int c = stack.pop();

		for (int i = 0; i < n; i++) {
			if (i != c && (knows(mat, c, i) || !knows(mat, i, c)))
				return -1;
		}

		return c;
	}

	public static void main(String[] args) {
		int n = 4;

		int mat[][] = { 
				{ 0, 0, 1, 0 }, 
				{ 0, 0, 1, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 1, 0 } 
		};
		
		System.out.println(findCelebrity(mat, n));

	}

}
