package com.app.practice.array;

public class CountNegativeNumbersInASortedMatrixLeetcode1351 {
	private static int countNeg(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		int count = 0;

		for (int i = m - 1; i >= 0; i--) {
			if (mat[i][0] < 0) {
				count += n;
			} else {
				int j = n - 1;
				while (j >= 0 && mat[i][j] < 0) {
					count++;
					j--;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] mat = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
		int count = countNeg(mat);

		System.out.println(count);

		mat = new int[][] { { 3, 2 }, { 1, 0 } };

		count = countNeg(mat);

		System.out.println(count);

		mat = new int[][] { { 1, -1 }, { -1, -1 } };
		
		count = countNeg(mat);

		System.out.println(count);


	}

}
