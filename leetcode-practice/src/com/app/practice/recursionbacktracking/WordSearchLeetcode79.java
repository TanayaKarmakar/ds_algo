package com.app.practice.recursionbacktracking;

public class WordSearchLeetcode79 {
	private static boolean canForm(char[][] board, String word, int i, int j, int start, boolean[][] visited) {
		if (start == word.length())
			return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
				|| visited[i][j] == true || board[i][j] != word.charAt(start))
			return false;
		visited[i][j] = true;
		boolean canForm = canForm(board, word, i + 1, j, start + 1, visited);

		canForm |= canForm(board, word, i - 1, j, start + 1, visited);
		canForm |= canForm(board, word, i + 1, j, start + 1, visited);
		canForm |= canForm(board, word, i, j - 1, start + 1, visited);
		canForm |= canForm(board, word, i, j + 1, start + 1, visited);

		if (canForm)
			return true;
		visited[i][j] = false;
		return false;
	}

	private static boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;

		boolean[][] visited = new boolean[m][n];
		int start = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(start)) {
					boolean canForm = canForm(board, word, i, j, start, visited);
					if (canForm)
						return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCEED";

		boolean exist = exist(board, word);

		System.out.println(exist);
	}

}
