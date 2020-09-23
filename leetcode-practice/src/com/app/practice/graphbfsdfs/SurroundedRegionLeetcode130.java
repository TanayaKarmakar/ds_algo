package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurroundedRegionLeetcode130 {
	private static void dfs(char[][] board, int r, int c, int x, int y) {
		if (x < 0 || x >= r || y < 0 || y >= c || board[x][y] != 'O')
			return;
		board[x][y] = 'E';
		dfs(board, r, c, x - 1, y);
		dfs(board, r, c, x + 1, y);
		dfs(board, r, c, x, y - 1);
		dfs(board, r, c, x, y + 1);
	}

	private static void solve(char[][] board) {
		if(board.length == 0)
			return;
		int r = board.length;
		int c = board[0].length;

		List<int[]> pairs = new ArrayList<>();
		for (int i = 0; i < c; i++) {
			pairs.add(new int[] { 0, i });
			pairs.add(new int[] { r - 1, i });
		}

		for (int i = 0; i < r; i++) {
			pairs.add(new int[] { i, 0 });
			pairs.add(new int[] { i, c - 1 });
		}

		for (int i = 0; i < pairs.size(); i++) {
			int x = pairs.get(i)[0];
			int y = pairs.get(i)[1];
			dfs(board, r, c, x, y);
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(board[i][j] == 'O')
					board[i][j] = 'X';
				else if(board[i][j] == 'E')
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
