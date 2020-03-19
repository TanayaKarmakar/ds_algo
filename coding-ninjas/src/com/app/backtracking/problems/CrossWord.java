package com.app.backtracking.problems;

import java.util.Scanner;

public class CrossWord {
	private static final int BOARD_SIZE = 10;

	private static void printSolution(char[][] board) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean isValidVertical(char[][] board, String word, int row, int col, boolean[] temp) {
		int n = word.length();
		if (row + n - 1 >= BOARD_SIZE)
			return false;
		int j = 0;
		for (int i = row; i < (row + n); i++) {
			if (!(board[i][col] == '-' || board[i][col] == word.charAt(j))) {
				return false;
			}
			j++;
		}
		return true;
	}

	private static boolean isValidHorizontal(char[][] board, String word, int row, int col, boolean[] temp) {
		int n = word.length();
		if (col + n - 1 >= BOARD_SIZE)
			return false;
		int j = 0;
		for (int i = col; i < col + n; i++) {
			if (!(board[row][i] == '-' || board[row][i] == word.charAt(j))) {
				return false;
			}
			j++;
		}
		return true;
	}

	private static void setHorizontal(char[][] board, String word, int row, int col, boolean[] temp) {
		int n = word.length();
		int j = 0;
		for (int i = col; i < col + n; i++) {
			if (board[row][i] == '-') {
				board[row][i] = word.charAt(j);
				temp[j] = true;
			}
			j++;
		}
	}

	private static void resetHorizontal(char[][] board, String word, int row, int col, boolean[] temp) {
		int n = word.length();
		int j = 0;
		for (int i = col; i < col + n; i++) {
			if (temp[j]) {
				board[row][i] = '-';
				temp[j] = false;
			}
			j++;
		}
	}

	private static void setVertical(char[][] board, String word, int row, int col, boolean[] temp) {
		int n = word.length();
		int j = 0;
		for (int i = row; i < row + n; i++) {
			if (board[i][col] == '-') {
				board[i][col] = word.charAt(j);
				temp[j] = true;
			}
			j++;
		}
	}

	private static void resetVertical(char[][] board, String word, int row, int col, boolean[] temp) {
		int n = word.length();
		int j = 0;
		for (int i = row; i < row + n; i++) {
			if (temp[j]) {
				board[i][col] = '-';
				temp[j] = false;
			}
			j++;
		}
	}

	private static boolean solve(char[][] board, String[] words, int startIndx) {
		if (startIndx == words.length) {
			printSolution(board);
			return true;
		}

		String currentWord = words[startIndx];
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				boolean[] temp = new boolean[currentWord.length()];
				if (board[i][j] != '+') {
					if (isValidVertical(board, currentWord, i, j, temp)) {
						setVertical(board, currentWord, i, j, temp);
						if (solve(board, words, startIndx + 1))
							return true;
						resetVertical(board, currentWord, i, j, temp);
					}

					if (isValidHorizontal(board, currentWord, i, j, temp)) {
						setHorizontal(board, currentWord, i, j, temp);
						if (solve(board, words, startIndx + 1))
							return true;
						resetHorizontal(board, currentWord, i, j, temp);
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

		for (int i = 0; i < BOARD_SIZE; i++) {
			String boardRow = scanner.nextLine();
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = boardRow.charAt(j);
			}
		}
		
		String inputStr = scanner.nextLine();
		solve(board, inputStr.split(";"), 0);
		
		scanner.close();

	}

}
