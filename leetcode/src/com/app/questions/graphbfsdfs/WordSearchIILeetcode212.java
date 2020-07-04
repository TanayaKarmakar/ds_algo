package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.List;


public class WordSearchIILeetcode212 {
	private static final int[] rDir = { -1, 1, 0, 0 };
	private static final int[] cDir = { 0, 0, -1, 1 };

	private static boolean isPresent(char[][] board, int i, int j, String word, int start, boolean[][] visited) {
		if (start == word.length())
			return true;
		
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)
				|| visited[i][j] == true)
			return false;
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int newRow = rDir[k] + i;
			int newCol = cDir[k] + j;
			if (isPresent(board, newRow, newCol, word, start + 1, visited) == true)
				return true;
		}

		visited[i][j] = false;
		return false;
	}

	private static boolean containsWord(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		int start = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(start)) {
					boolean isPresent = isPresent(board, i, j, word, start, visited);
					if (isPresent)
						return true;
				}
			}
		}
		return false;
	}

	private static List<String> findWords(char[][] board, String[] words) {
		List<String> output = new ArrayList<>();

		for (String word : words) {
			if (containsWord(board, word) == true) {
				output.add(word);
			}
		}

		return output;
	}

	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		String[] words = { "oath", "pea", "eat", "rain" };

		List<String> res = findWords(board, words);

		System.out.println(res);
	}

}
