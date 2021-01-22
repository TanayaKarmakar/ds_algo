package com.app.dynamicprogramming;

public class KnightProbabilityOnChessBoard {
	private static final int[][] dirs = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 },
			{ 2, 1 } };

	private static boolean isValid(int i, int j, int n) {
		return (i >= 0 && i < n && j >= 0 && j < n);
	}

	private static double totalProbs(int startRow, int startCol, int nMoves, int boardSize) {
		int n = boardSize;

		double[][] curr = new double[n][n];
		double[][] next = new double[n][n];
		
		curr[startRow][startCol] = 1;

		for (int k = 1; k <= nMoves; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (curr[i][j] != 0) {
						for (int i1 = 0; i1 < dirs.length; i1++) {
							int ni = i + dirs[i1][0];
							int nj = j + dirs[i1][1];
							if(isValid(ni, nj, n)) {
								next[ni][nj] += curr[i][j] / 8.0;
							}
						}
					}
				}
			}
			curr = next;
			next = new double[n][n];
		}
		
		double totalProbs = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(curr[i][j] != 0) {
					totalProbs = curr[i][j];
				}
			}
		}

		return totalProbs;
	}

	public static void main(String[] args) {
		int n = 5;
		int r = 2;
		int c = 2;
		int k = 2;
		
		double totalProbs = totalProbs(r, c, k, n);
		
		System.out.println(totalProbs);
	}

}
