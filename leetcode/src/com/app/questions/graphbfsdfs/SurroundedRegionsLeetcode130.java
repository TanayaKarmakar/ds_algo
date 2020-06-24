package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegionsLeetcode130 {
	private static void dfs(char[][] grid, int x, int y, int r, int c) {
		if(x < 0 || x >= r || y < 0 || y >= c || grid[x][y] != 'O')
			return;
		grid[x][y] = 'E';
		dfs(grid, x - 1, y, r, c);
		dfs(grid, x + 1, y, r, c);
		dfs(grid, x, y - 1, r, c);
		dfs(grid, x, y + 1, r, c);
	}

	private static void solve(char[][] board) {
		List<int[]> pairs = new ArrayList<>();
		int r = board.length;
		int c = board[0].length;
		
		for(int j = 0; j < c; j++) {
			pairs.add(new int[] {0, j});
			pairs.add(new int[] {r - 1, j});
		}
		
		for(int i = 0; i < r; i++) {
			pairs.add(new int[] {i, 0});
			pairs.add(new int[] {i, c - 1});
		}
		
		int size = pairs.size();
		for(int i = 0; i < size; i++) {
			int x = pairs.get(i)[0];
			int y = pairs.get(i)[1];
			dfs(board, x, y, r, c);
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
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, 
				{ 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		
		solve(board);
		
		int r = board.length;
		int c = board[0].length;
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
