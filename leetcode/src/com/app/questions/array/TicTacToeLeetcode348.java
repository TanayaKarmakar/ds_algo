package com.app.questions.array;

class TicTacToe {
	char[][] board;
	int size;

	public TicTacToe(int n) {
		board = new char[n][n];
		size = n;
	}

	public int move(int row, int col, int player) {
		char symbol = (player == 1) ? 'X' : 'O';
		board[row][col] = symbol;
		if (hasWon(symbol, row, col))
			return player;
		return 0;
	}

	private boolean hasWon(char symbol, int row, int col) {
		boolean hasWon = true;
		for (int i = 0; i < size; i++) {
			if (board[row][i] != symbol) {
				hasWon = false;
				break;
			}
		}
		if (hasWon)
			return true;
		hasWon = true;
		for (int i = 0; i < size; i++) {
			if (board[i][col] != symbol) {
				hasWon = false;
				break;
			}
		}
		if (hasWon)
			return true;
		hasWon = true;
		for (int i = 0; i < size; i++) {
			if (board[i][i] != symbol) {
				hasWon = false;
				break;
			}
		}

		if (hasWon)
			return true;
		hasWon = true;
		for (int i = 0; i < size; i++) {

			if (board[i][size - i - 1] != symbol) {
				hasWon = false;
				break;
			}

		}

		if (hasWon)
			return true;
		return false;
	}
}

public class TicTacToeLeetcode348 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
