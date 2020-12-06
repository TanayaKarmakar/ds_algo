package com.app.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputeRowsInPascalsTriangle {
	// approach from the book
	private static List<List<Integer>> approach2(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> currRow = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				int val1 = 0;
				if (j > 0 && j < i) {
					val1 = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
				} else {
					val1 = 1;
				}
				currRow.add(val1);
			}
			res.add(currRow);
		}
		return res;
	}

	// dp approach
	private static List<List<Integer>> approach1(int numRows) {
		int r = numRows;
		int c = 2 * r + 1;

		int[][] dp = new int[r][c];
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> currRow = new ArrayList<>();
		currRow.add(1);
		res.add(currRow);
		dp[0][r] = 1;
		for (int i = 1; i < r; i++) {
			currRow = new ArrayList<>();
			for (int j = 0; j < c; j++) {
				int val1 = 0;
				int val2 = 0;
				if (j - 1 >= 0) {
					val1 = dp[i - 1][j - 1];
				}
				if (j + 1 < c)
					val2 = dp[i - 1][j + 1];
				dp[i][j] = val1 + val2;
				if (dp[i][j] > 0)
					currRow.add(dp[i][j]);
			}
			res.add(currRow);
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		System.out.println("Approach1");
		List<List<Integer>> res = approach1(n);

		System.out.println(res);

		System.out.println("Approach2");
		res = approach2(n);

		System.out.println(res);
		scanner.close();

	}

}
