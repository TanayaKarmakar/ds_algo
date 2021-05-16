package com.app.recusrionbacktracking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 15/05/21
 * @project competitive-programming
 */
//branch and bound
public class NQueens {
    private static void printBoard(String[][] board) {
        System.out.println("**********************");
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solve(String[][] board, int row, boolean[] cols, boolean[] normalDiag,
                              boolean[] reverseDiag) {
        if(row == board.length) {
            printBoard(board);
            return;
        }

        for(int col = 0; col < board[0].length; col++) {
            if(!cols[col] && !normalDiag[row + col] && !reverseDiag[row - col + board.length - 1]) {
                board[row][col] = "Q";
                cols[col] = true;
                normalDiag[row + col] = true;
                reverseDiag[row - col + board.length - 1] = true;
                solve(board, row + 1, cols, normalDiag, reverseDiag);
                board[row][col] = "";
                cols[col] = false;
                normalDiag[row + col] = false;
                reverseDiag[row - col + board.length - 1] = false;
            }
        }
    }


    private static void nQueen(String[][] board, int n) {
        boolean[] cols = new boolean[n];
        boolean[] normalDiag = new boolean[2 * n - 1];
        boolean[] reverseDiag = new boolean[2 * n - 1];

        solve(board, 0, cols, normalDiag, reverseDiag);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[][] board = new String[n][n];
        for(int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], " ");
        }
        nQueen(board, n);
        scanner.close();
    }
}
