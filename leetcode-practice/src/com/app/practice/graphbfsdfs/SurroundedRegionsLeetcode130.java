package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurroundedRegionsLeetcode130 {
	private static void dfs(char[][] board, int i, int j, int m, int n) {
		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
			return;
		board[i][j] = 'E';
		dfs(board, i - 1, j, m, n);
		dfs(board, i + 1, j, m, n);
		dfs(board, i, j - 1, m, n);
		dfs(board, i, j + 1, m, n);
	}

	private static void solve(char[][] board) {
		if(board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;

		List<int[]> pairs = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			pairs.add(new int[] { 0, i });
			pairs.add(new int[] { m - 1, i });
		}

		for (int i = 0; i < m; i++) {
			pairs.add(new int[] { i, 0 });
			pairs.add(new int[] { i, n - 1 });
		}

		for (int i = 0; i < pairs.size(); i++) {
			int x = pairs.get(i)[0];
			int y = pairs.get(i)[1];

			dfs(board, x, y, m, n);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == 'E')
					board[i][j] = 'O';
			}
		}
	}

	public static void main(String[] args) {
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

		solve(board);

		System.out.println(Arrays.deepToString(board));

	}

}
