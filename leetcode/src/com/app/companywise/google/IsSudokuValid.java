package com.app.companywise.google;

import java.util.Arrays;
import java.util.Scanner;

public class IsSudokuValid {
	private static final int BOARD_SIZE = 9;

	private static boolean isPossible(int[][] grid, int row, int col, int num) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			if(i != col) {
				if (grid[row][i] == num)
					return false;
			}
		}

		for (int i = 0; i < BOARD_SIZE; i++) {
			if(i != row) {
				if (grid[i][col] == num)
					return false;
			}	
		}

		int end = 3;
		int boxRowStart = row - row % end;
		int boxColStart = col - col % end;

		for (int i = boxRowStart; i < boxRowStart + end; i++) {
			for (int j = boxColStart; j < boxColStart + end; j++) {
				if (grid[i][j] == num && i != row && j != col)
					return false;
			}
		}
		return true;
	}

	private static boolean isSudokuValid(int[][] grid) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (grid[i][j] != 0) {
					if (!isPossible(grid, i, j, grid[i][j])) {
						//System.out.println(i + " " + j);
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while (nTestCases > 0) {
			int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
			for (int i = 0; i < BOARD_SIZE; i++) {
				for (int j = 0; j < BOARD_SIZE; j++) {
					board[i][j] = scanner.nextInt();
				}
			}

			//System.out.println(Arrays.deepToString(board));
			boolean isPossible = isSudokuValid(board);
			System.out.println(isPossible ? 1 : 0);
			nTestCases--;
		}
		scanner.close();
	}

}
