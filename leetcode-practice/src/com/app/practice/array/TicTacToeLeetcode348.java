package com.app.practice.array;

class TicTacToe {
	char[][] board;
	int size;
	
	public TicTacToe(int n) {
		this.board = new char[n][n];
		this.size = n;
	}
	
	public int move(int row, int col, int player) {
		char symbol = (player == 1 ? 'X' : '0');
		board[row][col] = symbol;
		if(hasWon(row, col, symbol))
			return player;
		return 0;
	}
	
	private boolean hasWon(int row, int col, char symbol) {
		boolean hasWon = true;
		for(int i = 0; i < size; i++) {
			if(board[row][i] != symbol) {
				hasWon = false;
				break;
			}
		}
		
		if(hasWon)
			return true;
		
		for(int i = 0; i < size; i++) {
			if(board[i][col] != symbol) {
				hasWon = false;
				break;
			}
		}
		
		if(hasWon)
			return true;
		
		for(int i = 0; i < size; i++) {
			if(board[i][i] != symbol) {
				hasWon = false;
				break;
			}
		}
		
		if(hasWon)
			return true;
		
		for(int i = 0; i < size; i++) {
			if(board[i][size - i - 1] != symbol) {
				hasWon = false;
				break;
			}
		}
		
		if(hasWon)
			return true;
		return false;
	}	
}

public class TicTacToeLeetcode348 {

	public static void main(String[] args) {
		

	}

}
