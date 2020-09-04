package com.app.questions.binarysearch;

public class SearchInA2DMatrixLeetcode74 {
	private static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0)
            return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int lastRow = (m - 1);
		int lastCol = (n - 1);
		int start = 0;
		int end = n * lastRow + lastCol;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			int i = mid / n;
			int j = mid  - (i * n);
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		int target = 3;
		
		System.out.println(searchMatrix(matrix, target));

	}

}
