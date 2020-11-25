package com.app.questions.array;

import java.util.Arrays;

public class GameOfLifeLeetcode289 {
	private static int getLiveCellCount(int[][] board, int i, int j, int m, int n) {
		int count = 0;
		for (int r = i - 1; r <= (i + 1); r++) {
			for (int c = j - 1; c <= (j + 1); c++) {
				if (r < 0 || r >= m || c < 0 || c >= n || (r == i && c == j))
					continue;
				if (board[r][c] == 1)
					count++;
			}
		}
		return count;
	}

	private static void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;

		int[][] outputBoard = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int liveCellCount = getLiveCellCount(board, i, j, m, n);
				if (board[i][j] == 1) {
					if (liveCellCount == 2 || liveCellCount == 3)
						outputBoard[i][j] = 1;
				} else {
					if (liveCellCount == 3) {
						outputBoard[i][j] = 1;
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = outputBoard[i][j];
			}
		}
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

		gameOfLife(grid);
		
		System.out.println(Arrays.deepToString(grid));
	}

}
