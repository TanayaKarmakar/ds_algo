package com.app.practice.array;

public class SearchInA2DMatrixLeetcode240 {
	private static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;

		int start = 0;
		int end = n * (m - 1) + (n - 1);

		while (start <= end) {
			int mid = (start + end) >> 1;
			int r = (mid / n);
			int c = (mid % n);
			if (matrix[r][c] == target)
				return true;
			else if (matrix[r][c] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
	
		int target = 3;
		boolean ans = searchMatrix(matrix, target);
		
		System.out.println(ans);
	}

}
