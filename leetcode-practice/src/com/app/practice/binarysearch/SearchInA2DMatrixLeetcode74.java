package com.app.practice.binarysearch;

public class SearchInA2DMatrixLeetcode74 {
	private static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;

		int start = 0;
		int end = (m * n) - 1;

		while (start <= end) {
			int mid = (start + end) >> 1;
			int i1 = mid / n;
			int j1 = mid % n;
			if (matrix[i1][j1] == target)
				return true;
			else if (matrix[i1][j1] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		boolean ans = searchMatrix(matrix, 3);
		
		System.out.println(ans);
		
		ans = searchMatrix(matrix, 13);
		
		System.out.println(ans);

	}

}
