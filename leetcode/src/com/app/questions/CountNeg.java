package com.app.questions;

public class CountNeg {
	private static int countNeg(int[][] grid) {
		int nRow = grid.length;
		int nCol = grid[0].length;
		
		int count = 0;
		int i = nRow - 1;
		int j = 0;
		while(i >= 0 && j < nCol) {
			if(grid[i][j] >= 0) {
				j++;
			} else {
				count += (nCol - j);
				i--;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		int[][] grid = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
		System.out.println("Count - " + countNeg(grid));
	
	}

}
