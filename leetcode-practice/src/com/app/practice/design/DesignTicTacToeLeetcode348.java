package com.app.practice.design;

class TicTacToe {
	char[][] board;
	int size;

	/** Initialize your data structure here. */
	public TicTacToe(int n) {
		size = n;
		board = new char[n][n];
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row    The row of the board.
	 * @param col    The column of the board.
	 * @param player The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		char sign;
		if (player == 1) {
			board[row][col] = 'X';
			sign = 'X';
		} else {
			board[row][col] = 'O';
			sign = 'O';
		}
		
		boolean hasWon = hasWon(sign, row, col);
		if(hasWon)
			return player;
		return 0;
	}

	private boolean hasWon(char sign, int row, int col) {
		boolean won = true;
		// check row wise
		for (int i = 0; i < size; i++) {
			if (board[i][col] != sign) {
				won = false;
				break;
			}
		}
		
		if(won)
			return true;
		
		won = true;

		// check column wise
		for (int j = 0; j < size; j++) {
			if (board[row][j] != sign) {
				won = false;
				break;
			}
		}
		
		if(won)
			return true;
		won = true;

		// check diagonally
		for (int i = 0; i < size; i++) {
			if (board[i][i] != sign) {
				won = false;
				break;
			}
		}
		
		if(won)
			return true;
		won = true;

		// check anti diagonally
		for (int i = 0; i < size; i++) {
			if (board[i][size - i - 1] != sign) {
				won = false;
				break;
			}		
		}
		return won;
	}
}

public class DesignTicTacToeLeetcode348 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
