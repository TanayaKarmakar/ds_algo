package com.app.dp1.problems;

import java.util.Arrays;
import java.util.Scanner;

public class AlyonaAndSpreadSheet {
	private static boolean isSorted(int[] nums, int start, int end) {
		int rowVal = nums[end];
		return rowVal <= start;
	}

	private static int[] processArray(int[][] sheet, int m, int n) {
		int[][] dp = new int[m + 1][n];

		for (int i = 0; i < n; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= m; i++) {
			for (int j = 0; j < n; j++) {
				if (sheet[i - 1][j] <= sheet[i][j]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = i;
				}
			}
		}

		int[] nums = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				min = Integer.min(min, dp[i][j]);
			}
			nums[i] = min;
		}

		System.out.println(Arrays.toString(nums));
		return nums;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nRows = scanner.nextInt();
		int nCols = scanner.nextInt();

		int[][] sheet = new int[nRows + 1][nCols];

		for (int i = 1; i <= nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				sheet[i][j] = scanner.nextInt();
			}
		}
		int[] nums = processArray(sheet, nRows, nCols);
		int nQueries = scanner.nextInt();
		while (nQueries > 0) {
			int startRow = scanner.nextInt();
			int endRow = scanner.nextInt();
			boolean isSorted = isSorted(nums, startRow, endRow);
			if(isSorted) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			nQueries--;
		}
		scanner.close();
	}

}
