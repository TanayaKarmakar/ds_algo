package com.app.practice.graphbfsdfs;

import java.util.HashSet;
import java.util.Set;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

public class WordSearchLeetcode79 {
	private static int[] rDir = { -1, 1, 0, 0 };
	private static int[] cDir = { 0, 0, -1, 1 };

	private static boolean exist(char[][] board, String word, int i, int j, Set<Point> visited, int start) {
		if(start == word.length())
			return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
				|| visited.contains(new Point(i, j))
				|| board[i][j] != word.charAt(start))
			return false;
		visited.add(new Point(i, j));

		for (int k = 0; k < 4; k++) {
			int newRow = i + rDir[k];
			int newCol = j + cDir[k];

			if (exist(board, word, newRow, newCol, visited, start + 1) == true)
				return true;
		}
		visited.remove(new Point(i, j));
		return false;
	}

	private static boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;

		int start = 0;

		Set<Point> visited = new HashSet<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(start)) {
					boolean isPossible = exist(board, word, i, j, visited, start);
					if (isPossible) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String s = "ABCCED";
		
		boolean isPossible = exist(board, s);
		
		System.out.println(isPossible);
		
		s = "SEE";
		
		isPossible = exist(board, s);
		
		System.out.println(isPossible);
		
		s = "ABCB";
		
		isPossible = exist(board, s);
		
		System.out.println(isPossible);
	}

}
