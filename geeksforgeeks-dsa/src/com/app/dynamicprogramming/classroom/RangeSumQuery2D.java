package com.app.dynamicprogramming.classroom;

public class RangeSumQuery2D {
	private static int rangeSum(int[][] mat, int tli, int tlj, int rbi, int rbj) {
		int row = mat.length;
		int col = mat[0].length;
		
		int[][] aux = new int[row][col];
		for(int i = 0; i < col; i++) {
			aux[0][i] = mat[0][i];
		}
		
		//compute sum columnwise
		for(int j = 0; j < col; j++) {
			for(int i = 1; i < row; i++) {
				aux[i][j] = aux[i - 1][j] + mat[i][j];
			}
		}
		
		//compute sum rowwise
		for(int i = 0; i < row; i++) {
			for(int j = 1; j < col; j++) {
				aux[i][j] = aux[i][j] + aux[i][j - 1];
			}
		}
		
		int rangeSum = aux[rbi][rbj];
		rangeSum -= aux[tli - 1][rbj];
		rangeSum -= aux[rbi][tlj - 1];
		rangeSum += aux[tli - 1][tlj - 1];
		
		return rangeSum;
	}

	public static void main(String[] args) {
		int[][] mat = {
				{1, 2, 3, 4, 6}, 
				{5, 3, 8, 1, 2}, 
				{4, 6, 7, 5, 5}, 
				{2, 4, 8, 9, 4}};
		
		int sum = rangeSum(mat, 2, 2, 3, 4);
		
		System.out.println("Sum - " + sum);

	}

}
