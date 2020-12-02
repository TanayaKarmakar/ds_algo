package com.app.practice.array;

import java.util.Arrays;

public class GameOfLifeLeetcode289 {
	private static int getLiveCellCount(int[][] board, int i, int j, int m, int n) {
		int count = 0;
		for (int r = i - 1; r <= (i + 1); r++) {
			for (int c = j - 1; c <= (j + 1); c++) {
				if (r < 0 || r >= m || c < 0 || c >= n || (r == i && c == j))
					continue;
				if (Math.abs(board[r][c]) == 1)
					count++;
			}
		}

		return count;
	}

	private static void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int liveCellCount = getLiveCellCount(board, i, j, m, n);

				if (board[i][j] == 1 && (liveCellCount < 2 || liveCellCount > 3))
					board[i][j] = -1;

				if (board[i][j] == 0 && liveCellCount == 3)
					board[i][j] = 2;
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] > 1)
					board[i][j] = 1;
				if (board[i][j] < 0)
					board[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(grid);
		
		System.out.println(Arrays.deepToString(grid));
	}

}
