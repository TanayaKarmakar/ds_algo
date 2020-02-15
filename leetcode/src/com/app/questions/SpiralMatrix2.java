package com.app.questions;

import java.util.Arrays;

public class SpiralMatrix2 {
	private static int[][] spiralMatrix(int n) {
		int totItr = 2 * n - 1;
		int[][] mat = new int[n][n];

		int startRow = 0;
		int endRow = n - 1;
		int startCol = 0;
		int endCol = n - 1;
		int count = 1;
		for (int i = 0; i < totItr; i++) {
			for (int j = startCol; j <= endCol; j++) {
				mat[startRow][j] = count++;
			}
			startRow++;

			for (int j = startRow; j <= endRow; j++) {
				mat[j][endCol] = count++;
			}
			
			endCol--;
			
			for(int j = endCol; j>= startCol; j--) {
				mat[endRow][j] = count++;
			}
			
			endRow--;
			
			for(int j = endRow; j>= startRow; j--) {
				mat[j][startCol] = count++;
			}
			
			startCol++;
		}
		
		return mat;

	}

	public static void main(String[] args) {
		int[][] mat = spiralMatrix(3);
		
		System.out.println(Arrays.deepToString(mat));

	}

}
