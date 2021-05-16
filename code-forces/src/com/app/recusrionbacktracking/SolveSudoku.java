package com.app.recusrionbacktracking;

/**
 * @author t0k02w6 on 09/05/21
 * @project competitive-programming
 */
public class SolveSudoku {
    private static final int GRID_SIZE = 9;

    private static boolean isValid(int[][] board, int row, int col, int option) {
        for(int c = 0; c < GRID_SIZE; c++) {
            if(board[row][c] == option)
                return false;
        }

        for(int r = 0; r < GRID_SIZE; r++) {
            if(board[r][col] == option)
                return false;
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for(int r = startRow; r < startRow + 3; r++) {
            for(int c = startCol; c < startCol + 3; c++) {
                if(board[r][c] == option)
                    return false;
            }
        }
        return true;
    }

    private static boolean solveSudoku(int[][] board) {
        int row = -1;
        int col = -1;
        for(int i = 0; i < GRID_SIZE; i++) {
            for(int j = 0; j < GRID_SIZE; j++) {
                if(board[i][j] == 0) {
                    row = i;
                    col = j;
                    break;
                }
            }
            if(row != -1)
                break;
        }

        if(row == -1)
            return true;

        for(int option = 1; option <= GRID_SIZE; option++) {
            if(isValid(board, row, col, option)) {
                board[row][col] = option;
                if(solveSudoku(board))
                    return true;
                board[row][col] = 0;
            }
        }

        return false;
    }

    private static void printBoard(int[][] board) {
        for(int i = 0; i < GRID_SIZE; i++) {
            for(int j = 0; j < GRID_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] board = {{3,0,6,5,0,8,4,0,0},{5,2,0,0,0,0,0,0,0},{0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},{9,0,0,8,6,3,0,0,5},{0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},{0,0,0,0,0,0,0,7,4},{0,0,5,2,0,6,3,0,0}};

        solveSudoku(board);

        printBoard(board);

    }
}
