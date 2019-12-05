package com.app.matrix.classroom;

public class SearchElementInRowwiseColumnWiseSortedMatrix {
	private static void searchElement(int[][] mat, int key) {
		int r = mat.length;
		int c = mat[0].length;

		int elem = 0;

		int i = 0;
		int j = c - 1;

		while (i < r && j >= 0) {
			elem = mat[i][j];
			if (elem == key) {
				System.out.println("r - " + i + ", c - " + j);
				return;
			} else if (elem < key)
				i++;
			else
				j--;
			
		}
		System.out.println("Element not found");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 10, 20, 30 }, { 15, 25, 80 }, { 35, 90, 100 } };
		searchElement(mat, 10);
		
		searchElement(mat, 25);
		
		searchElement(mat, 80);
		
		searchElement(mat, 26);

	}

}
