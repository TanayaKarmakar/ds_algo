package com.app.questions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	private static List<Integer> printSpiralMatrix(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;

		int startRow = 0;
		int endRow = row - 1;
		int startCol = 0;
		int endCol = col - 1;

		int nTimes = 0;

		if (row <= col) {
			nTimes = 2 * row - 1;
		} else {
			nTimes = 2 * col;
		}

		int j = 0;
		int totalElem = row * col;
		int traversedElCount = 0;
		for (int i = 0; i < nTimes; i++) {
			if(traversedElCount == totalElem)
				break;
			for (j = startCol; j <= endCol; j++) {
				//System.out.print(matrix[startRow][j] + " ");
				res.add(matrix[startRow][j]);
				traversedElCount++;
			}
			
			if(traversedElCount == totalElem)
				break;
			
			startRow++;
			for (j = startRow; j <= endRow; j++) {
				//System.out.print(matrix[j][endCol] + " ");
				res.add(matrix[j][endCol]);
				traversedElCount++;
			}
			if(traversedElCount == totalElem)
				break;
			
			endCol--;
			for (j = endCol; j >= startCol; j--) {
				//System.out.print(matrix[endRow][j] + " ");
				res.add(matrix[endRow][j]);
				traversedElCount++;
			}
			
			if(traversedElCount == totalElem)
				break;
			
			endRow--;
			for (j = endRow; j >= startRow; j--) {
				//System.out.print(matrix[j][startCol] + " ");
				res.add(matrix[j][startCol]);
				traversedElCount++;
			}
			startCol++;
		}
		//System.out.println();
		return res;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printSpiralMatrix(mat);

	}

}
