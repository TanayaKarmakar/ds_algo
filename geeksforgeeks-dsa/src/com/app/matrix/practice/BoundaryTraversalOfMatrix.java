package com.app.matrix.practice;

public class BoundaryTraversalOfMatrix {
	private static void boundaryTraversalSquareShape(int[][] mat) {
		int startRow = 0;
		int startCol = 0;
		int endRow = mat.length - 1;
		int endCol = mat[0].length - 1;
		
		for(int i = 0;i <= endRow;i++) {
			for(int j = 0;j<=endCol;j++) {
				if(i == startRow || i == endRow || j == startCol) {
					System.out.print(mat[i][j] + " ");
				} else if(j == endCol) {
					System.out.print(" " + mat[i][j]);
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void boundaryTraversal(int[][] mat) {
		int startRow = 0;
		int startCol = 0;
		int endRow = mat.length - 1;
		int endCol = mat[0].length - 1;
		

		for (int i = startCol; i <= endCol; i++) {
			System.out.print(mat[startRow][i] + " ");
		}

		startRow++;
		for (int i = startRow; i <= endRow; i++) {
			System.out.print(mat[i][endCol] + " ");
		}

		endCol--;
		for (int i = endCol; i >= startCol; i--) {
			System.out.print(mat[endRow][i] + " ");
		}

		endRow--;
		for (int i = endRow; i >= startRow; i--) {
			System.out.print(mat[i][startCol] + " ");
		}
		
		System.out.println();

	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		boundaryTraversal(mat);
		boundaryTraversalSquareShape(mat);
		
		mat = new int[][] {{1,2},{5,17}};
		boundaryTraversal(mat);
		
		
	}

}
