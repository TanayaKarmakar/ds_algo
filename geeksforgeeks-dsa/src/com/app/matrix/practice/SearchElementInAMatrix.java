package com.app.matrix.practice;

public class SearchElementInAMatrix {
	private static int search(int[][] mat, int key) {
		int row = mat.length;
		int col = mat[0].length;
		int i = 0;
		int j = col - 1;

		while (i < row && j >= 0) {
			if (mat[i][j] == key) {
				return 1;
			} else if (mat[i][j] < key) {
				i++;
			} else {
				j--;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[][] mat = { { 3, 30, 38 }, { 44, 52, 54 }, { 57, 60, 69 } };

		System.out.println(search(mat, 62));

		mat = new int[][] { { 18, 21, 27, 38, 55, 67 } };
		
		System.out.println(search(mat, 55));
	}

}
