package com.app.questions.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleLeetcode118 {
	private static List<List<Integer>> generate(int numRows) {
		if (numRows == 0)
			return new ArrayList<>();
		int r = numRows;
		int c = 2 * numRows + 1;
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> item = new ArrayList<>();
		item.add(1);
		res.add(item);

		int[][] dp = new int[r][c];
		dp[0][numRows] = 1;

		for (int i = 1; i < r; i++) {
			item = new ArrayList<>();
			for (int j = 0; j < c; j++) {
				int val1 = 0;
				int val2 = 0;
				if (j - 1 >= 0)
					val1 = dp[i - 1][j - 1];
				if (j + 1 < c)
					val2 = dp[i - 1][j + 1];
				dp[i][j] = val1 + val2;
				if (dp[i][j] > 0)
					item.add(dp[i][j]);
			}
			res.add(item);
		}

		return res;
	}

	public static void main(String[] args) {
		int n = 5;
		List<List<Integer>> res = generate(n);

		System.out.println(res);

	}

}
