package com.app.questions.binarysearch;

import java.util.ArrayList;
import java.util.List;

interface BinaryMatrix {
	public int get(int row, int col);

	public List<Integer> dimensions();
}

class BinaryMatrixImpl implements BinaryMatrix {
	private int[][] matrix;
	private int nRows;
	private int nCols;

	public BinaryMatrixImpl(int[][] matrix) {
		this.matrix = matrix;
		this.nRows = matrix.length;
		this.nCols = matrix[0].length;
	}

	@Override
	public int get(int row, int col) {
		return matrix[row][col];
	}

	@Override
	public List<Integer> dimensions() {
		List<Integer> dims = new ArrayList<>();
		dims.add(nRows);
		dims.add(nCols);
		return dims;
	}

}

public class LeftmostColumnWithAtleastAOneLeetcode1428 {
	private static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int nRows = dimensions.get(0);
		int nCols = dimensions.get(1);

		int i = 0;
		int j = nCols - 1;
		int minIndx = -1;
		while(i < nRows && j >= 0) {
			if(binaryMatrix.get(i, j) == 1) {
				minIndx = j;
				j--;
			} else {
				i++;
			}
		}
		return minIndx;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0 }, { 0, 1 } };
		BinaryMatrix bMatrix = new BinaryMatrixImpl(matrix);
		
		System.out.println(leftMostColumnWithOne(bMatrix));

	}

}
