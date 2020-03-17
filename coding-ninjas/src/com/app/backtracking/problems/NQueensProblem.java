package com.app.backtracking.problems;

import java.util.Arrays;

public class NQueensProblem {
	private static final String QUEEN = "Q";

	private static boolean isSafe(String[][] pos, int n, int row, int col) {
		// if any other queen in the same row
		for (int i = row - 1; i >= 0; i--) {
			if (pos[i][col].equals(QUEEN))
				return false;
		}

		//upper left diagonal
		for(int i = row, j = col; i >= 0 & j >= 0;i--,j--) {
			if(pos[i][j].equals(QUEEN))
				return false;
		}
		
		//upper right diagonal
		for(int i = row, j = col;i >= 0 && j < n;i--,j++) {
			if(pos[i][j].equals(QUEEN))
				return false;
		}
		return true;
	}

	private static boolean solve(String[][] pos, int n, int row) {
		if (row == n) {
			printSolution(pos, n);
			return false;
		}
		//boolean res = false;
		for (int i = 0; i < n; i++) {
			if (isSafe(pos, n, row, i)) {
				pos[row][i] = "Q";
				if (solve(pos, n, row + 1)) 
					return true;
				pos[row][i] = "";
			}
		}
		return false;
	}

	private static void printSolution(String[][] solution, int n) {
		System.out.println("--------");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (solution[i][j].equals("")) {
					System.out.print("| ");
				} else {
					System.out.print("|" + solution[i][j]);
				}
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("--------");
	}

	public static void main(String[] args) {
		int n = 4;
		String[][] solution = new String[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(solution[i], "");
		}

		solve(solution, n, 0);
	}

}
