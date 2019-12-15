package com.app.matrix.practice;

public class SpiralMatrix {
	private static void printSpiral(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		int limit = 0;
		if (row <= col) {
			limit = 2 * row - 1;
		} else {
			limit = 2 * col;
		}

		int startRow = 0;
		int startCol = 0;
		int endRow = row - 1;
		int endCol = col - 1;
		int totalElem = row * col;
		int traversedElemCount = 0;

		for (int i = 0; i <= limit; i++) {
			if(traversedElemCount == totalElem)
				break;
			
			for (int j = startCol; j <= endCol; j++) {
				System.out.print(mat[startRow][j] + " ");
				traversedElemCount++;
			}
			
			if(traversedElemCount == totalElem)
				break;
			
			startRow++;
			for (int j = startRow; j <= endRow; j++) {
				System.out.print(mat[j][endCol] + " ");
				traversedElemCount++;
			}
			
			if(traversedElemCount == totalElem)
				break;

			endCol--;
			for (int j = endCol; j >= startCol; j--) {
				System.out.print(mat[endRow][j] + " ");
				traversedElemCount++;
			}
			
			if(traversedElemCount == totalElem)
				break;

			endRow--;
			for (int j = endRow; j >= startRow; j--) {
				System.out.print(mat[j][startCol] + " ");
				traversedElemCount++;
			}
			startCol++;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printSpiral(mat);

		mat = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printSpiral(mat);

		mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } };
		printSpiral(mat);
	}

}
