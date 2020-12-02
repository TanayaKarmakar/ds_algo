package com.app.questions.dp;

public class LongestLineOfConsecutiveOnesLeetcode562 {
	private static int longestLine(int[][] M) {
		if(M.length == 0)
			return 0;
		int m = M.length;
		int n = M[0].length;

		int[][] dpH = new int[m][n];
		int[][] dpV = new int[m][n];
		int[][] dpD = new int[m][n];
		int[][] dpaD = new int[m][n];

		int maxVal = 0;

		// horizontal
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (M[i][j] == 1) {
					dpH[i][j] = (j == 0) ? 1 : 1 + dpH[i][j - 1];
				}
				maxVal = Integer.max(maxVal, dpH[i][j]);
			}
			
		}

		// vertical
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (M[i][j] == 1) {
					dpV[i][j] = (i == 0) ? 1 : 1 + dpV[i - 1][j];
				}
				maxVal = Integer.max(maxVal, dpV[i][j]);
			}
		}

		// diagonal
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(M[i][j] == 1) {
					if((i - 1) >= 0 && (j - 1) >= 0) {
						dpD[i][j] = 1 + dpD[i - 1][j - 1];
					} else {
						dpD[i][j] = 1;
					}
					maxVal = Integer.max(maxVal, dpD[i][j]);
				}
			}
		}

		// anti-diagonal
		for (int i = 0; i < m; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if(M[i][j] == 1) {
					if((i - 1) >= 0 && (j + 1) <= n - 1) {
						dpaD[i][j] = 1 + dpaD[i - 1][j + 1];
					} else {
						dpaD[i][j] = 1;
					}
					maxVal = Integer.max(maxVal, dpaD[i][j]);
				}
			}
		}
		
		return maxVal;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0}, {1, 1}};

		//int[][] grid = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 1 } };

		//int[][] grid = {{0},{1}};
		
		int maxVal = longestLine(grid);

		System.out.println(maxVal);

	}

}
