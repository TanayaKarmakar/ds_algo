package com.app.questions.dp;

public class RangeSumQuery2D {
	private static int rangeSumQuery(int[][] mat, int x1, int y1, int x2, int y2) {
		int m = mat.length;
		int n = mat[0].length;

		int[][] aux = new int[m][n];

		for (int i = 0; i < n; i++)
			aux[0][i] = mat[0][i];

		// column wise sum
		for (int j = 0; j < n; j++) {
			for (int i = 1; i < m; i++) {
				aux[i][j] = aux[i - 1][j] + mat[i][j];
			}
		}

		// rowwise sum
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				aux[i][j] += aux[i][j - 1];
			}
		}

		int result = aux[x2][y2] - aux[x1 - 1][y2] - aux[x2][y1 - 1] + aux[x1 - 1][y1 - 1];

		return result;

	}

	public static void main(String[] args) {
		int[][] mat = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 }, 
				{ 9, 10, 11, 12 }, 
				{ 13, 14, 15, 16 } 
			};
		int sum = rangeSumQuery(mat, 1, 1, 2, 2);
		
		System.out.println(sum);
	}

}
