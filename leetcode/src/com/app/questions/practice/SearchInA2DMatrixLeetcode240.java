package com.app.questions.practice;

public class SearchInA2DMatrixLeetcode240 {
	private static boolean searchMatrix(int[][] matrix, int item) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		if(row == 0)
			return false;
		
		int i = 0;
		int j = col - 1;
		
		while(i < row && j >= 0) {
			if(matrix[i][j] == item)
				return true;
			else if(matrix[i][j] > item) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = {{5, 10, 15, 25}, {6, 11, 16, 26}, {7, 12, 17, 27}};
		
		int target = 16;
		
		System.out.println(searchMatrix(matrix, target));
		
		target = 13;
		
		System.out.println(searchMatrix(matrix, target));

	}

}
