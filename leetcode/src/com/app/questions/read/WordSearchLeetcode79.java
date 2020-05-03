package com.app.questions.read;

import java.util.HashSet;
import java.util.Set;

class Point {
	int x;
	int y;

	public Point() {

	}

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
	private static boolean canForm(char[][] board, String word, int i, int j, int start, Set<Point> visited) {
		if(start == word.length())
			return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return false;
		if (board[i][j] != word.charAt(start) || visited.contains(new Point(i, j)))
			return false;
		
		Point point = new Point(i, j);
		visited.add(point);
		
		boolean canForm = canForm(board, word, i - 1, j, start + 1, visited);
		canForm |= canForm(board, word, i + 1, j, start + 1, visited);
		canForm |= canForm(board, word, i, j - 1, start + 1, visited);
		canForm |= canForm(board, word, i, j + 1, start + 1, visited);
		if(canForm)
			return true;
		visited.remove(point);
		return false;
	}

	private static boolean exist(char[][] board, String word) {
		Set<Point> visited = new HashSet<>();
		int m = board.length;
		int n = board[0].length;

		int start = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(start)) {
					boolean canForm = canForm(board, word, i, j, start, visited);
					if(canForm)
						return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] grid = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(grid, "ABCCED"));
		System.out.println(exist(grid, "SEE"));
		System.out.println(exist(grid, "ABCB"));
		
		grid = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
		System.out.println(exist(grid, "AAB"));
	}

}
