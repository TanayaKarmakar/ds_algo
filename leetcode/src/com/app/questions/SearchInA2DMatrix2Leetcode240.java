package com.app.questions;

public class SearchInA2DMatrix2Leetcode240 {
	private static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if(m == 0)
			return false;
		int n = matrix[0].length;

		int i = 0;
		int j = n - 1;
		while (i < m && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] > target)
				j--;
			else
				i++;
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30} };
		boolean found = searchMatrix(mat, 5);
		
		System.out.println(found);
		
		found = searchMatrix(mat, 20);
		System.out.println(found);
	}

}
