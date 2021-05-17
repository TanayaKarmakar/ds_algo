package com.app.recusrionbacktracking;

import java.util.Scanner;

/**
 * @author t0k02w6 on 17/05/21
 * @project competitive-programming
 */
public class CrosswordProblem {
    private static void solution(char[][] board, String[] words, int vidx) {
        if(vidx == words.length) {
            print(board);
            return;
        }

        String word = words[vidx];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '-' || board[i][j] == word.charAt(0)) {
                    if(canPlaceHorizontally(board, word, i, j)) {
                        boolean[] placed = placeWordHorizontally(board, word, i, j);
                        solution(board, words, vidx + 1);
                        unplaceWordHorizontally(board, word, placed, i, j);
                    }


                    if(canPlaceVertically(board, word, i, j)) {
                        boolean[] placed = placeWordVertically(board, word, i, j);
                        solution(board, words, vidx + 1);
                        unplaceWordVertically(board, word, placed, i, j);
                    }
                }
            }
        }
    }

    public static void unplaceWordVertically(char[][] board, String word, boolean[] placed, int i, int j) {
        for(int ii = 0; ii < word.length(); ii++) {
            if(placed[ii]) {
                board[i + ii][j] = '-';
            }
        }
    }

    public static void unplaceWordHorizontally(char[][] board, String word, boolean[] placed, int i, int j) {
        for(int jj = 0; jj < word.length(); jj++) {
            if(placed[jj]) {
                board[i][j + jj] = '-';
            }
        }
    }

    private static boolean[] placeWordVertically(char[][] board, String word, int i, int j) {
        boolean[] placed = new boolean[word.length()];

        for(int ii = 0; ii < word.length(); ii++) {
            if(board[i + ii][j] == '-') {
                board[i + ii][j] = word.charAt(ii);
                placed[ii] = true;
            }
        }
        return placed;
    }


    private static boolean[] placeWordHorizontally(char[][] board, String word, int i, int j) {
        boolean[] placed = new boolean[word.length()];

        for(int jj = 0; jj < word.length(); jj++) {
            if(board[i][j + jj] == '-') {
                board[i][j + jj] = word.charAt(jj);
                placed[jj] = true;
            }
        }
        return placed;
    }

    private static boolean canPlaceVertically(char[][] board, String word, int i, int j) {
        if(i - 1 >= 0 && board[i - 1][j] != '+')
            return false;
        if(i + word.length() < board.length && board[i + word.length()][j] != '+')
            return false;

        for(int ii = 0; ii < word.length(); ii++) {
            if(i + ii >= board[0].length)
                return false;
            if(board[i + ii][j] == '-' || board[i + ii][j] == word.charAt(ii))
                continue;
            else
                return false;
        }
        return true;
    }

    private static boolean canPlaceHorizontally(char[][] board, String word, int i, int j) {
        if(j - 1 >= 0 && board[i][j - 1] != '+')
            return false;
        if(j + word.length() < board[0].length && board[i][j + word.length()] != '+')
            return false;

        for(int jj = 0; jj < word.length(); jj++) {
            if(j + jj >= board[0].length)
                return false;
            if(board[i][j + jj] == '-' || board[i][j + jj] == word.charAt(jj))
                continue;
            else
                return false;
        }
        return true;
    }

    private static void print(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
//        char[][] board = new char[10][10];
//
//        Scanner scanner = new Scanner(System.in);
//        for(int i = 0; i < board.length; i++) {
//            String str = scanner.next();
//            board[i] = str.toCharArray();
//        }
//
//        int n = scanner.nextInt();
//        String[] words = new String[n];
//
//        for(int i = 0; i < n; i++) {
//            words[i] = scanner.next();
//        }
//
//        scanner.close();

        char[][] board = {
                {'+','-','+','+','+','+','+','+','+','+'},
                {'+','-','+','+','+','+','+','+','+','+'},
                {'+','-','+','+','+','+','+','+','+','+'},
                {'+','-','-','-','-','-','+','+','+','+'},
                {'+','-','+','+','+','-','+','+','+','+'},
                {'+','-','+','+','+','-','+','+','+','+'},
                {'+','+','+','+','+','-','+','+','+','+'},
                {'+','+','-','-','-','-','-','-','+','+'},
                {'+','+','+','+','+','-','+','+','+','+'},
                {'+','+','+','+','+','-','+','+','+','+'}};

        String[] words = {"DELHI", "ICELAND", "ANKARA", "LONDON"};

        solution(board, words, 0);
    }
}
