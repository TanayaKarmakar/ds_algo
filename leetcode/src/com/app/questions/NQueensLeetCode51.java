package com.app.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensLeetCode51 {
	private static boolean isSafe(char[][] board, int row, int col, int n) {
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col] == 'Q')
				return false;
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q')
				return false;
		}

		for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
			if (board[i][j] == 'Q')
				return false;
		}
		return true;
	}
	
	private static void addItemToRes(List<List<String>> res, char[][] board, int n) {
		List<String> item = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j<n;j++) {
				sb.append(board[i][j]);
			}
			item.add(sb.toString());
		}
		res.add(item);
	}

	private static boolean solve(char[][] board, int startIndx, int n, List<List<String>> res) {
		if (startIndx == n) {
			addItemToRes(res, board, n);
			return false;
		}
		for (int i = 0; i < n; i++) {
			if (isSafe(board, startIndx, i, n)) {
				board[startIndx][i] = 'Q';
				if(solve(board, startIndx + 1, n, res))
					return true;
				board[startIndx][i] = '.';
			}

		}
		return false;
	}

	private static List<List<String>> solveQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(board[i], '.');
		}

		List<List<String>> res = new ArrayList<>();
		solve(board, 0, n, res);
		System.out.println(res);

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		List<List<String>> output = solveQueens(n);
		for (List<String> el : output) {
			System.out.println(el);
		}
	}

}
