package com.app.practice;

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
	private static boolean canForm(char[][] board, String word, int i, int j, int m, int n, Set<Point> visited,
			int indx) {
		if (indx == word.length())
			return true;
		if (i < 0 || i >= m || j < 0 || j >= n)
			return false;
		if (word.charAt(indx) != board[i][j] || visited.contains(new Point(i, j))) {
			return false;
		}
		
		Point point = new Point(i, j);
		visited.add(point);
		boolean canForm = canForm(board, word, i - 1, j, m, n, visited, indx + 1);
		canForm |= canForm(board, word, i + 1, j, m, n, visited, indx + 1);
		canForm |= canForm(board, word, i, j - 1, m, n, visited, indx + 1);
		canForm |= canForm(board, word, i, j + 1, m, n, visited, indx + 1);
		if (canForm)
			return true;
		visited.remove(point);
		return false;
	}

	private static boolean exist(char[][] board, String word) {
		Set<Point> visited = new HashSet<>();
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (canForm(board, word, i, j, m, n, visited, 0))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board, "ABCCED"));
		System.out.println(exist(board, "SEE"));
		System.out.println(exist(board, "ABCB"));
	}

}
