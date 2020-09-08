package com.app.practice.array;

class TicTacToe {
	char[][] board;
	int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
    	size = n;
        board = new char[size][size];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
    	char symbol = (player == 1 ? 'X': '0');
        board[row][col] = symbol;
        if(hasWon(row, col, symbol))
        	return player;
        return 0;
    }
    
    private boolean hasWon(int row, int col, char symbol) {
    	boolean hasWon = true;
    	for(int i = 0; i < size; i++) {
    		if(board[row][i] != symbol){
    			hasWon = false;
    			break;
    		}
    	}
    	
    	if(hasWon)
    		return true;
    	hasWon = true;
    	for(int i = 0; i < size; i++) {
    		if(board[i][col] != symbol) {
    			hasWon = false;
    			break;
    		}
    	}
    	
    	if(hasWon)
    		return true;
    	hasWon = true;
    	
    	for(int i = 0; i < size; i++) {
    		if(board[i][i] != symbol) {
    			hasWon = false;
    			break;
    		}
    	}
    	
    	if(hasWon)
    		return true;
    	hasWon = true;
    	
    	for(int i = 0, j = size - 1; i < size && j >= 0; i++, j--) {
    		if(board[i][j] != symbol) {
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
		// TODO Auto-generated method stub

	}

}
